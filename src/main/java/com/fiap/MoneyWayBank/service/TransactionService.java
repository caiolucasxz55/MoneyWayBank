package com.fiap.MoneyWayBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.fiap.MoneyWayBank.repository.TransactionRepository;

public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @PostMapping
    public TransactionService Depositar(){
        
    }
}
