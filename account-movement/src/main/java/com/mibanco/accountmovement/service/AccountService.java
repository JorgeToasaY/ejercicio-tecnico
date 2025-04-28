package com.mibanco.accountmovement.service;

import com.mibanco.accountmovement.dto.AccountRequestDTO;
import com.mibanco.accountmovement.dto.AccountResponseDTO;
import com.mibanco.accountmovement.dto.AccountUpdateRequestDTO;
import com.mibanco.accountmovement.entity.Account;

import java.util.List;

public interface AccountService {
    AccountResponseDTO createAccount(AccountRequestDTO request);
    AccountResponseDTO updateAccount(String accountNumber, AccountUpdateRequestDTO request);
    void deleteAccount(String accountNumber);
    List<AccountResponseDTO> getAllAccounts();
    AccountResponseDTO getAccountById(Long id);
    AccountResponseDTO findByAccountNumber(String accountNumber);
    List<Account> findByCustomerId(String customerId);
    void updateAccountByCustomerId(String customerId, Boolean state);
}
