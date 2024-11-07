package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerrServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository repository;
    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
