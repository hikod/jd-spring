package com.cydeo.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName; // firstName saved as first_name in the database
    private String lastName;
    private String email;
}
