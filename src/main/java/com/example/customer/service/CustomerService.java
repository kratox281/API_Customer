package com.example.customer.service;

import com.example.customer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CustomerService {
    public List<Customer> getAllCustomers() ;
    public Optional<Customer> getCustomerById(Long id);
    public Customer saveCustomer(Customer customer);
    public void deleteCustomer(Long id);



}
