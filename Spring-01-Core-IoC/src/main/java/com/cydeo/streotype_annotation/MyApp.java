package com.cydeo.streotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyApp.class);
    }
}
