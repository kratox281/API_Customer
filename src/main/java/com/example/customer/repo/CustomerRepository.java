package com.example.customer.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

}
