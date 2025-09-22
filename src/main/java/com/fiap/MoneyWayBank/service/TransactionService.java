package com.fiap.MoneyWayBank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.MoneyWayBank.dto.BasicTransactionRequest;
import com.fiap.MoneyWayBank.model.Account;
import com.fiap.MoneyWayBank.model.Transaction;
import com.fiap.MoneyWayBank.repository.TransactionRepository;
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;
    
    public Transaction deposit(BasicTransactionRequest request) {
        Account account = accountService.getAccountById(request.accountId());
        account.setBalance(account.getBalance().add(request.amount()));
        
        Transaction transaction = Transaction.builder()
            .targetAccount(account)
            .amount(request.amount())
            .build();
        
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long id){
        return transactionRepository
                    .findById(id)
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found with id " + id));
    }
}
