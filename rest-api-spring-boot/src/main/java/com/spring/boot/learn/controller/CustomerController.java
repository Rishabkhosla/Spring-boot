package com.spring.boot.learn.controller;

import com.spring.boot.learn.model.Customer;
import com.spring.boot.learn.service.Customerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class CustomerController {

    @Autowired
    private Customerservice service;

    @GetMapping("/customer_data")
    public List<Customer> list() {
        return service.listAll();
    }

    @GetMapping("/filter_data")
    public List<Customer> filter_list() {
        return service.filter_list();
    }


   @GetMapping("/get_cust/{country}")
   public List<Customer> get(@PathVariable String country) {
       return  service.getString(country);
   }




    @GetMapping("/get_customer/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        try {
            Customer cust = service.get(id);
            return new ResponseEntity<Customer>(cust, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/posting")
    public void add(@RequestBody List<Customer> customer) {
       service.save(customer);
    }
//

    @PutMapping("/Customers")

    public ResponseEntity<Customer> update(@RequestBody  List<Customer> customer) {
        try {
              for (Customer c : customer) {
                    service.delete(c.getCust_id());{

                    service.save(customer);
                }
                return new ResponseEntity<Customer>(c, HttpStatus.OK);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return null;
    }


    @DeleteMapping("/delete_customer/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
