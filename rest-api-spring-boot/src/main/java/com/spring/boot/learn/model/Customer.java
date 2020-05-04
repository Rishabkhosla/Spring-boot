package com.spring.boot.learn.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    private Integer cust_id;
    private String name;
    private Integer quantity;
    private String country;

    public Customer() {

    }

    public Customer(Integer cust_id, String name, Integer quantity, String country) {
        this.cust_id = cust_id;
        this.name = name;
        this.quantity = quantity;
        this.country = country;
    }

//   @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//

   @Id
    public Integer getCust_id() {
        return cust_id;
    }

    public String getCountry() {
        return country;
    }
}
