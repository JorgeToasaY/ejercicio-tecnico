package com.mibanco.customerperson.service.impl;

import com.mibanco.customerperson.dto.CustomerRequestDTO;
import com.mibanco.customerperson.dto.CustomerResponseDTO;
import com.mibanco.customerperson.dto.CustomerUpdateRequestDTO;
import com.mibanco.customerperson.entity.Customer;
import com.mibanco.customerperson.event.CustomerEventPublisher;
import com.mibanco.customerperson.exception.CustomerException;
import com.mibanco.customerperson.mapper.CustomerMapper;
import com.mibanco.customerperson.repository.CustomerRepository;
import com.mibanco.customerperson.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerEventPublisher customerEventPublisher;


    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.toEntity(customerRequestDTO);
        CustomerResponseDTO customerResponseDTO = customerMapper.toDto(customerRepository.save(customer));
        // Enviar evento al otro microservicio
        //customerEventPublisher.sendCustomerCreatedEvent(customerResponseDTO);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer with id " + id + " not found"));
        return customerMapper.toDto(customer);


    }
    @Override
    public CustomerResponseDTO getCustomerByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerException("Customer with id " + customerId + " not found"));
        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {

        return customerMapper.toDtoList(customerRepository.findAll());
    }

    @Override
    public CustomerResponseDTO updateCustomer(String customerId, CustomerUpdateRequestDTO customerUpdate) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerException("Customer with id " + customerId + " not found"));

        customer.setState(customerUpdate.getState());
        customer.setAddress(customerUpdate.getAddress());
        customer.setPhone(customerUpdate.getPhone());
        CustomerResponseDTO customerResponseDTO = customerMapper.toDto(customerRepository.save(customer));
        // Enviar evento al otro microservicio
        if(customer.getState().compareTo(customerUpdate.getState()) !=0) {
            customerEventPublisher.sendCustomerUpdateEvent(customerResponseDTO);
        }
        return customerResponseDTO;


    }

    @Override
    public void deleteCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer with id " + id + " not found"));
        customerRepository.deleteById(id);

    }
    @Override
    @Transactional
    public void deleteCustomerByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerException("Customer with customerId " + customerId + " not found"));
        customerRepository.deleteByCustomerId(customer.getCustomerId());


    }
}
