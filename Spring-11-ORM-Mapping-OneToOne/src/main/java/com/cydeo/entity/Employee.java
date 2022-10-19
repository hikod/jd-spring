package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity{

    private String first_name;
    private String last_name;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hired_date;
    private int salary;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Employee(String first_name, String last_name, String email, LocalDate hired_date, int salary, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.hired_date = hired_date;
        this.salary = salary;
        this.gender = gender;
    }
}
