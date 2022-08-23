package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class);
         FullTimeMentor ftm = container.getBean(FullTimeMentor.class);
        ftm.createAccount();
    }
}
