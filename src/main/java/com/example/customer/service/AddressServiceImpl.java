package com.example.customer.service;

import com.example.customer.model.Address;
import com.example.customer.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> getAddressesByCustomerId(Long customerId) {
        return List.of();
    }

//    public List<Address> getAddressesByCustomerId(Long customerId) {
//        return addressRepository.findByCustomerId(customerId);
//    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
