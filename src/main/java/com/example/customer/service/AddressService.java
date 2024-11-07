package com.example.customer.service;

import com.example.customer.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public List<Address>getAll();
    public List<Address> getAddressesByCustomerId(Long customerId);
    public Address saveAddress(Address address);
    public void deleteAddress(Long id);
}
