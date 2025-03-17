package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.Employee;
import com.leo.cardriverentals.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setBirthDate(employee.getBirthDate());
        existingEmployee.setCpf(employee.getCpf());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setUserProfilePicture(employee.getUserProfilePicture());
        existingEmployee.setStatus(employee.getStatus());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setRole(employee.getRole());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmploee(Long id) {
        employeeRepository.deleteById(id);
    }
}
