package com.boot.rest.controller;

import com.boot.rest.dao.EmployeeDAO;
import com.boot.rest.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

}
