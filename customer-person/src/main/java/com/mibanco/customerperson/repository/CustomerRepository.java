package com.mibanco.customerperson.repository;

import com.mibanco.customerperson.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerId(String customerId);
    void deleteByCustomerId(String customerId);
}
