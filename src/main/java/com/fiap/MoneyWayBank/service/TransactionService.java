package com.fiap.MoneyWayBank.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.MoneyWayBank.dto.BasicTransactionRequest;
import com.fiap.MoneyWayBank.dto.PixTransactionRequest;
import com.fiap.MoneyWayBank.model.Account;
import com.fiap.MoneyWayBank.model.Transaction;
import com.fiap.MoneyWayBank.repository.TransactionRepository;
import com.fiap.MoneyWayBank.types.TransactionType;
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
            .type(TransactionType.DEPOSIT)
            .transactionDate(LocalDateTime.now())
            .build();
        
        return transactionRepository.save(transaction);
    }


    public Transaction withdraw(BasicTransactionRequest request) {
        Account account = accountService.getAccountById(request.accountId());

        if (account.getBalance().compareTo(request.amount()) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds");
        }
        
        account.setBalance(account.getBalance().subtract(request.amount()));

        Transaction transaction = Transaction.builder()
            .sourceAccount(account)
            .amount(request.amount())
            .type(TransactionType.WITHDRAWAL)
            .transactionDate(LocalDateTime.now())
            .build();

        return transactionRepository.save(transaction);
    }

    public Transaction pix(PixTransactionRequest request){
        Account account1 = accountService.getAccountById(request.sourceAccountId());

        Account account2 = accountService.getAccountById(request.targetAccountId());

        if (account1.getBalance().compareTo(request.amount()) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds");
        }

        if (account1.getId().equals(account2.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Source and target accounts must be different");
        }

        account1.setBalance(account1.getBalance().subtract(request.amount()));
        account2.setBalance(account2.getBalance().add(request.amount()));

        Transaction transaction = Transaction.builder()
            .sourceAccount(account1)
            .targetAccount(account2)
            .amount(request.amount())
            .type(TransactionType.PIX)
            .transactionDate(LocalDateTime.now())
            .build();

        return transactionRepository.save(transaction);

    }

    public Transaction getTransactionById(Long id){
        return transactionRepository
                    .findById(id)
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found with id " + id));
    }
}
