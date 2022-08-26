package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class);
        // container can hold many Configuration files
        // ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor ftm = container.getBean(FullTimeMentor.class);

        // p1 refers to the object in ConfigApp
        PartTimeMentor ptm = container.getBean("p1", PartTimeMentor.class);


        ftm.createAccount();
        ptm.createAccount();
    }
}
