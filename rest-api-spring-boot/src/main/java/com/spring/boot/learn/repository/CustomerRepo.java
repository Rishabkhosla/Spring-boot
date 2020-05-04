package com.spring.boot.learn.repository;

import com.spring.boot.learn.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface CustomerRepo  extends JpaRepository<Customer, Integer> {

//    @Query("SELECT  quantity FROM Customer  WHERE quantity = 0 ")
    List<Customer> findByQuantityLessThan(Integer quantity);


    public List<Customer> findByCountry(String country);

//    public static final String FIND_PROJECTS = "SELECT cust_id FROM Customer";
//    @Query(value = "SELECT   c.cust_id  FROM Customer c", nativeQuery = true)
//    public List<Customer> findProjects();
}
