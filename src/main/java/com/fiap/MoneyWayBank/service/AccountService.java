package com.fiap.MoneyWayBank.service;

import com.fiap.MoneyWayBank.model.Account;
import com.fiap.MoneyWayBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        if (accountRepository.existsByNumber(account.getNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account number " + account.getNumber() + " already exists");
        }
        
        if (account.isActive()) {
            accountRepository.findFirstByCpfHolderAndActiveTrue(account.getCpfHolder())
                .filter(existing -> !existing.getId().equals(account.getId()))
                .ifPresent(existing -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already an active account for this CPF");
                });
        }
        
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found with id " + id));
    }

    public Account deactivateAccount(Long id){
        var conta = getAccountById(id);
        conta.setActive(false);
        return accountRepository.save(conta);
    }

}
