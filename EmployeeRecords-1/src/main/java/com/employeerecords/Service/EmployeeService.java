package com.employeerecords.Service;


import com.employeerecords.Model.Employee;
import com.employeerecords.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + employeeId));
        employee.setName(employeeDetails.getName());
        employee.setAge(employeeDetails.getAge());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
