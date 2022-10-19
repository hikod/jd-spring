package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "regions")
public class Region  extends BaseEntity{
    private String region;
    private String country;

    @OneToOne(mappedBy = "region") //creating bi-directional relationship
    private Employee employee;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
