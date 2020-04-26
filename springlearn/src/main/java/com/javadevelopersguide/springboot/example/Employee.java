package com.javadevelopersguide.springboot.example;

public class Employee {

    private int emp_id;
    private String name ;
    private String salary;

    public Employee(){}

    public Employee(int emp_id, String name, String salary) {
        this.emp_id = emp_id;
        this.name = name;
        this.salary = salary;
    }

    //getter setter created to access private variables
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
