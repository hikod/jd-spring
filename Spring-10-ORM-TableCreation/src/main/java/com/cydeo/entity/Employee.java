package com.cydeo.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private Long id;

    private String name;

}
