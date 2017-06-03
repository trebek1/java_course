package com.example.mypackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 6/3/17.
 */
public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees(){
        return employees;
    }
}
