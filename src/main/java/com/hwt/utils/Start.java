package com.hwt.utils;


import com.hwt.annotation.QueryTable;
import com.hwt.bean.dict.TestBean;
import jdk.nashorn.api.scripting.ClassFilter;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Start {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Field[] declaredFields = TestBean.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            if (name.equals("tempString")) {
                declaredField.setAccessible(true);
                declaredField.set(TestBean.class, "asdfasf");
            }
        }
        System.out.println(TestBean.tempString);
        System.in.read();
        List<Annotation> annotationList = new ArrayList<>();
        Reflections relections = new Reflections(new ConfigurationBuilder()
                .forPackages("com.hwt.bean")
                .addScanners(new TypeAnnotationsScanner())
                .filterInputsBy(new FilterBuilder().include(".*class")));
        Set<Class<?>> queryTableAnns = relections.getTypesAnnotatedWith(QueryTable.class);
        System.out.println(queryTableAnns);
        Iterator<Class<?>> iterator = queryTableAnns.iterator();
        while (iterator.hasNext()) {
            Class<?> next = iterator.next();
            QueryTable annotation = next.getAnnotation(QueryTable.class);
            System.out.println(annotation);
            annotationList.add(annotation);
        }
        Annotation[] annotations = new Annotation[annotationList.size()];
        annotationList.toArray(annotations);
        QueryTableChange queryTableChange = new QueryTableChange();
        queryTableChange.changeAnnotationContent(annotations);
        queryTableChange.seeAnnotations(annotations);
    }
}
