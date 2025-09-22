package com.fiap.MoneyWayBank.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.MoneyWayBank.dto.BasicTransactionRequest;
import com.fiap.MoneyWayBank.model.Transaction;
import com.fiap.MoneyWayBank.repository.TransactionRepository;
import com.fiap.MoneyWayBank.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RequestMapping("/transactions")
@RestController
public class TransactionController {


    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction deposit(@RequestBody @Valid BasicTransactionRequest request) {
        log.info("Creating a transaction " + request);
        return transactionService.deposit(request);
    }
}
