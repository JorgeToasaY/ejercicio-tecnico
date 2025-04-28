package com.mibanco.customerperson.controller;

import com.mibanco.customerperson.dto.CustomerRequestDTO;
import com.mibanco.customerperson.dto.CustomerResponseDTO;
import com.mibanco.customerperson.dto.CustomerUpdateRequestDTO;
import com.mibanco.customerperson.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok(customerService.getCustomerByCustomerId(customerId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> listCustomers() {

        return ResponseEntity.ok(customerService.listCustomers());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable String customerId, @RequestBody CustomerUpdateRequestDTO customer) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId) throws Exception {
        customerService.deleteCustomerByCustomerId(customerId);
        return ResponseEntity.ok("Customer with customerId " + customerId + " eliminated");
    }

}
