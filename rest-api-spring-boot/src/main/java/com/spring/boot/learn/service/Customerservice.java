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


    public List<Customer> save(List<Customer> cust) {

       return repo.saveAll(cust);
//        return list;
    }

    public Customer saveupdate(Customer cust) {

        return repo.save(cust);
//        return list;
    }

    public Customer get(Integer id) {
        return repo.findById(id).get();
    }

    public List<Customer> getString(String country) {
        return repo.findByCountry(country);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Customer> filter_list(){

       return  repo.findByQuantityLessThan(1);
    }


//    public List<Customer> get_cust(){
//
//        return  repo.findProjects();
//    }



    }




