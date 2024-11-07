package com.example.customer.controller;

import com.example.customer.model.Address;
import com.example.customer.model.Customer;
import com.example.customer.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers/{customerId}/addresses")
@Tag(name = "Address API", description = "API for managing customer addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Operation(summary = "Get all addresses for a customer", description = "Retrieve all addresses associated with a customer")
    @GetMapping
    public List<Address> getAddressesByCustomerId(@PathVariable Long customerId) {
        return addressService.getAddressesByCustomerId(customerId);
    }

    @Operation(summary = "Add a new address for a customer", description = "Create a new address for a specific customer")
    @PostMapping
    public Address createAddress(@PathVariable Long customerId, @RequestBody Address address) {
        address.setCustomer(new Customer(customerId));
        return addressService.saveAddress(address);
    }

    @Operation(summary = "Delete an address for a customer", description = "Delete a specific address associated with a customer")
    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
    }
}
