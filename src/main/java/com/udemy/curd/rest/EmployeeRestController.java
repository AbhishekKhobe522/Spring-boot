package com.udemy.curd.rest;

import com.udemy.curd.entity.Employee;
import com.udemy.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService =  theEmployeeService;
    }

    @GetMapping("/emp")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/emp/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
           throw new RuntimeException("Employee id not found - :"+ employeeId);
        }
        return  theEmployee;
    }

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee DbEmployee = employeeService.save(theEmployee);
        return DbEmployee;
    }
    @PutMapping("/emp")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return  dbEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null ){
            throw new RuntimeException("invalid id - "+employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Employee Deleted Successful";

    }
}
