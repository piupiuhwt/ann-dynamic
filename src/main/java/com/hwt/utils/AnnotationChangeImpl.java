package com.hwt.utils;

import com.hwt.annotation.QueryTable;
import com.hwt.bean.dict.TestBean;

import java.lang.annotation.Annotation;
import java.util.Collection;

public class AnnotationChangeImpl {
    public static void main(String[] args) throws ClassNotFoundException{
        ClassLoader classLoader = AnnotationChangeImpl.class.getClassLoader();
        Class<?> aClass = Class.forName("com.hwt.bean.dict.TestBean");
        QueryTable annotation = aClass.getAnnotation(QueryTable.class);


        System.out.println(annotation.value());

        TestBean o1 = new TestBean();
        QueryTable annotation1 = o1.getClass().getAnnotation(QueryTable.class);
        System.out.println(annotation1.value());
    }

    public Collection<Annotation> getAnnotations(Collection<Class<?>> classes){
        return null;
    }

    public void changeAnnotationValue(Collection<Annotation> annotations,Class<?> clazz){
        if (clazz.equals(QueryTable.class)) {
            handleChangeQueryTableValue(annotations);
        }
    }

    public void handleChangeQueryTableValue(Collection<Annotation> annotations){

    }
}
