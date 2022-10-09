package com.cydeo.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
