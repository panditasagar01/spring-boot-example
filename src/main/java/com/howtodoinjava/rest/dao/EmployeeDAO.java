package com.howtodoinjava.rest.dao;

import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    private static Employees list = new Employees();

    static {
        list.getEmployeeList().add(new Employee(1, "Rajesh", "Singh", "testemail@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Ajay", "Kumar", "ajay564@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Sagar", "Pandita", "sam123@gmail.com"));
    }

    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
