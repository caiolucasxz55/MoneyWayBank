package com.fiap.MoneyWayBank.service;

import com.fiap.MoneyWayBank.model.Account;
import com.fiap.MoneyWayBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada com id " + id));
    }

    public Account deactivateAccount(Long id){
        var conta = getAccountById(id);
        conta.setActive(false);
        return accountRepository.save(conta);
    }

}
