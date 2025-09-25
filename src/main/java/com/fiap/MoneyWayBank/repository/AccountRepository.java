package com.fiap.MoneyWayBank.repository;

import com.fiap.MoneyWayBank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByCpfHolderAndActiveTrue(String cpfHolder);
    Optional<Account> findFirstByCpfHolderAndActiveTrue(String cpfHolder);
}
