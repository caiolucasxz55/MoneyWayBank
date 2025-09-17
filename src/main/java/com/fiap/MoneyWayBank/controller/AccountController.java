package com.fiap.MoneyWayBank.controller;


import com.fiap.MoneyWayBank.model.Account;
import com.fiap.MoneyWayBank.repository.AccountRepository;
import com.fiap.MoneyWayBank.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/accounts")
@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> index(){
        return accountRepository.findAll();
    }


    @GetMapping("{id}")
    public Account get(@PathVariable Long id ){
        return accountService.getCategoryById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public List<Account> indexCpf(@PathVariable String cpf){
        return accountService.buscarPorCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account){
        log.info("Creating account " + account);
        
        return accountService.save(account);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy (@PathVariable Long id){
        accountRepository.delete(accountService.getCategoryById(id));
    }

    @PutMapping("/cpf/{cpf}/encerrar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void encerrarContasPorCpf(@PathVariable String cpf) {
        List<Account> contas = accountService.buscarPorCpf(cpf);
        contas.forEach(conta -> conta.setActive(false));
        accountRepository.saveAll(contas);
    }

    @PutMapping("{id}")
    public Account update(@PathVariable Account accountUpdated, @RequestBody  Long id){
        accountService.getCategoryById(id);
        accountUpdated.setId(id);
        return accountRepository.save(accountUpdated);
    }





}
