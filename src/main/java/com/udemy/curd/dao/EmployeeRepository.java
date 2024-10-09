package com.udemy.curd.dao;

import com.udemy.curd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
}
