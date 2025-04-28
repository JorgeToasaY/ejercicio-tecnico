package com.mibanco.customerperson.service;

import com.mibanco.customerperson.dto.CustomerRequestDTO;
import com.mibanco.customerperson.dto.CustomerResponseDTO;
import com.mibanco.customerperson.dto.CustomerUpdateRequestDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO getCustomerByCustomerId(String customerId);
    List<CustomerResponseDTO> listCustomers();
    CustomerResponseDTO updateCustomer(String customerId, CustomerUpdateRequestDTO customerRequestDTO);
    void deleteCustomerById(Long id);
    void deleteCustomerByCustomerId(String id);
}
