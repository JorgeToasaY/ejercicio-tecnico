package com.mibanco.accountmovement.controller;

import com.mibanco.accountmovement.dto.AccountRequestDTO;
import com.mibanco.accountmovement.dto.AccountResponseDTO;
import com.mibanco.accountmovement.dto.AccountUpdateRequestDTO;
import com.mibanco.accountmovement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> create(@RequestBody @Validated AccountRequestDTO request) {
        return new ResponseEntity<>(accountService.createAccount(request), HttpStatus.CREATED);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> update(@PathVariable String accountNumber, @RequestBody @Validated AccountUpdateRequestDTO request) {
        return ResponseEntity.ok(accountService.updateAccount(accountNumber, request));
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<String> delete(@PathVariable String accountNumber) {
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.ok("Account with accountNumber " + accountNumber + " eliminated");
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAll() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> getByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.findByAccountNumber(accountNumber));
    }
}
