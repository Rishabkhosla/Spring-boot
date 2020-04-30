package com.spring.boot.learn.service;

import com.spring.boot.learn.model.Customer;
import com.spring.boot.learn.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Customerservice {

        @Autowired
        private CustomerRepo repo;

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public Customer save(Customer cust) {
        repo.save(cust);
        return cust;
    }

    public Customer get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Customer> filter_list(){

       return  repo.findByQuantityLessThan(1);
    }


    }

