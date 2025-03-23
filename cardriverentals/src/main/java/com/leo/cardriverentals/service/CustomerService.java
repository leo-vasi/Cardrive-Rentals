package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.Customer;
import com.leo.cardriverentals.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById (Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer (Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("No Customer Found"));
        existingCustomer.setName(customer.getName());
        existingCustomer.setGender(customer.getGender());
        existingCustomer.setBirthDate(customer.getBirthDate());
        existingCustomer.setCpf(customer.getCpf());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setRentalHistory(customer.getRentalHistory());
        existingCustomer.setLoginHistory(customer.getLoginHistory());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer (Long id) {
        customerRepository.deleteById(id);
    }
}
