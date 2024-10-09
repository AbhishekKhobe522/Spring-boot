package com.udemy.curd.service;

import com.udemy.curd.dao.EmployeeRepository;
import com.udemy.curd.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository theEmployeeRepository ;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.theEmployeeRepository = employeeRepository;
    }



    @Override
    public List<Employee> findAll() {
        return theEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = theEmployeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else {
            throw new RuntimeException("did not find employee id :-"+theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee employee) {
        return theEmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        theEmployeeRepository.deleteById(id);
    }
}
