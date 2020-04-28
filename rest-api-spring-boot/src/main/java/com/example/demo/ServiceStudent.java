package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Configuration
public class ServiceStudent {



    // String method 1
    public Student_description stu_des() {
        return new Student_description("hi this information in the path /student_data is related" +
                " to students who are passed in class 10 from school lfcs gsp");
    }

    //create list
    private static List<Student> list=new ArrayList<>();
    //static block
    static {
    //adding users to the list
        list.add(new Student(1, "rishab","rishibrx@gmail.com",new Date()));
        list.add(new Student(2, "mohit","mohit14@gmail.com",new Date()));
    }

    //method 2 to fetch all records
    public List<Student> data() {
        return list;
    }
   //method 3 to fetch filter records on id
    public Student  datafilter(Integer id){
        for (Student req : list) {
            if (req.id == id)
                return req;
        }
        return null;
    }


    @PostMapping(path = "/save-cust-info")
    public String customerInformation(@RequestBody Student cust) {

        /* You can write your DAO logic here.
         * For time being I am printing the customer data just to show the POST call is working.
         */

        return "Customer information saved successfully ::." ;
    }



//    public Student save(Student student)
//    {
//
//        student.add(list);
//        return list;
//    }
}
