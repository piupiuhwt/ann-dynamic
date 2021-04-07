package com.hwt.utils;

import com.hwt.annotation.QueryTable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;

public class QueryTableChange implements AnnotationChange{

    @Override
    public boolean changeAnnotationContent(Annotation... annotations) {
        if (annotations==null||annotations.length==0) {
            return true;
        }
        for (Annotation annotation : annotations) {
            QueryTable queryTable = (QueryTable) annotation;
            queryTableChange(queryTable);
        }
        return false;
    }

    @Override
    public boolean changeAnnotationContent(Collection<Annotation> annotations) {
        return false;
    }

    public void seeAnnotations(Annotation... annotations){
        for (Annotation annotation : annotations) {
            QueryTable ann = (QueryTable)annotation;
            System.out.println(ann.value());
        }
    }

    private void queryTableChange(QueryTable queryTable){
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(queryTable);
        Field value = null;
        try {
            value = invocationHandler.getClass().getDeclaredField("memberValues");
            value.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
            memberValuesProcess(memberValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void memberValuesProcess(Map<String, Object> memberValues){
        Object value = memberValues.get("value");

    }
}
