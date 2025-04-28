package com.mibanco.customerperson.mapper;

import com.mibanco.customerperson.dto.CustomerRequestDTO;
import com.mibanco.customerperson.dto.CustomerResponseDTO;
import com.mibanco.customerperson.dto.CustomerUpdateRequestDTO;
import com.mibanco.customerperson.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequestDTO dto);
    Customer toEntity(CustomerUpdateRequestDTO dto);
    CustomerResponseDTO toDto(Customer entity);

    List<CustomerResponseDTO> toDtoList(List<Customer> entities);
}
