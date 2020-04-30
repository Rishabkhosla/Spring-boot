package com.spring.boot.learn.repository;

import com.spring.boot.learn.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo  extends JpaRepository<Customer, Integer> {

//    @Query("SELECT  quantity FROM Customer  WHERE quantity = 0 ")
    List<Customer> findByQuantityLessThan(Integer quantity);

}
