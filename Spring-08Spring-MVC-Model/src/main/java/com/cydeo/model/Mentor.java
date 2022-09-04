package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mentor {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}
