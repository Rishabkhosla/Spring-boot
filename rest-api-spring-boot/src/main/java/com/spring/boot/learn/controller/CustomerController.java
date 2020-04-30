package com.spring.boot.learn.controller;

import com.spring.boot.learn.model.Customer;
import com.spring.boot.learn.service.Customerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping("/get_customer/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        try {
            Customer cust = service.get(id);
            return new ResponseEntity<Customer>(cust, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Customers")
    public void add(@RequestBody Customer customer) {
        service.save(customer);
    }

    @PutMapping("/Customers/{id}")
    public Customer customer(@PathVariable(value = "id") Integer id,
                           @Valid @RequestBody Customer cust) {

        Customer custt = service.get(id);
        custt.setCust_id(cust.getCust_id());
        custt.setName(cust.getName());
        custt.setQuantity(cust.getQuantity());
        custt.setCountry(cust.getCountry());

        Customer updatedNote = service.save(custt);
        return updatedNote;
    }

    @DeleteMapping("/delete_customer/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
