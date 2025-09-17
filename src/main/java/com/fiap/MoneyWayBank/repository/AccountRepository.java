package com.fiap.MoneyWayBank.repository;

import com.fiap.MoneyWayBank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCpfHolder(String cpf);

    List<Account> findByCpfHolderAndActiveTrue(String cpfHolder);
}
