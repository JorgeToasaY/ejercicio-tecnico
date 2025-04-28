package com.mibanco.accountmovement.service.impl;

import com.mibanco.accountmovement.dto.AccountRequestDTO;
import com.mibanco.accountmovement.dto.AccountResponseDTO;
import com.mibanco.accountmovement.dto.AccountUpdateRequestDTO;
import com.mibanco.accountmovement.entity.Account;
import com.mibanco.accountmovement.exception.AccountException;
import com.mibanco.accountmovement.mapper.AccountMapper;
import com.mibanco.accountmovement.repository.AccountRepository;
import com.mibanco.accountmovement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO request) {
        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountType(request.getAccountType());
        account.setInitialBalance(request.getInitialBalance());
        account.setState(request.getState());
        account.setCustomerId(request.getCustomerId());
        account = accountRepository.save(account);
        return  accountMapper.toDto(account);
    }

    @Override
    public AccountResponseDTO updateAccount(String accountNumber, AccountUpdateRequestDTO request) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException("Account with accountNumber " + accountNumber + " not found"));
        account.setState(request.getState());
        return accountMapper.toDto(accountRepository.save(account));
    }
    @Override
    public void updateAccountByCustomerId(String customerId, Boolean state) {
        List<Account> listAccount = accountRepository.findByCustomerId(customerId);
        for (Account account : listAccount) {
            account.setState(state);
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException("Account with accountNumber " + accountNumber + " not found"));
        accountRepository.deleteById(account.getId());

    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return accountMapper.toDtoList(accountRepository.findAll());
    }

    @Override
    public AccountResponseDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountException("Account with id " + id + " not found"));
        return accountMapper.toDto(account);

    }

    @Override
    public AccountResponseDTO findByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException("Account with accountNumber " + accountNumber + " not found"));

        return accountMapper.toDto(account);

    }
    @Override
    public List<Account> findByCustomerId(String customerId){
        List<Account> listAccount = accountRepository.findByCustomerId(customerId);
        if (listAccount.isEmpty()) {
            throw new AccountException("No accounts found for customerId: " + customerId);
        }

        return listAccount;
    }

}
