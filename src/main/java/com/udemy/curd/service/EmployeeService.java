package com.udemy.curd.service;

import com.udemy.curd.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService  {
    List<Employee> findAll();

   Employee findById(int theId);

    Employee save(Employee employee);

   public  void deleteById (int id);

}
