package com.hwt.utils;

import java.lang.annotation.Annotation;
import java.util.Collection;
public interface AnnotationChange {

    boolean changeAnnotationContent(Annotation... annotations);

    boolean changeAnnotationContent(Collection<Annotation> annotations);

}
