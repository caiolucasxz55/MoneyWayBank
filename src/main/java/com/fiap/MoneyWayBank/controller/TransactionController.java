package com.fiap.MoneyWayBank.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.MoneyWayBank.dto.BasicTransactionRequest;
import com.fiap.MoneyWayBank.dto.PixTransactionRequest;
import com.fiap.MoneyWayBank.model.Transaction;
import com.fiap.MoneyWayBank.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction deposit(@RequestBody @Valid BasicTransactionRequest request) {
        log.info("Creating a deposit transaction " + request);
        return transactionService.deposit(request);
    }

    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction withdraw(@RequestBody @Valid BasicTransactionRequest request) {
        log.info("Requesting a withdraw " + request);
        return transactionService.withdraw(request);
    }

    @PostMapping("/pix")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction pix(@RequestBody @Valid PixTransactionRequest request) {
        log.info("Creating a pix transaction " + request);
        return transactionService.pix(request);
    }
    
}
