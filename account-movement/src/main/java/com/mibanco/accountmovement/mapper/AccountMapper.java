package com.mibanco.accountmovement.mapper;

import com.mibanco.accountmovement.dto.AccountRequestDTO;
import com.mibanco.accountmovement.dto.AccountResponseDTO;
import com.mibanco.accountmovement.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toEntity(AccountRequestDTO dto);

    AccountResponseDTO toDto(Account entity);

    List<AccountResponseDTO> toDtoList(List<Account> entities);
}
