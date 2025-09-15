package com.fiap.MoneyWayBank.repository;

import com.fiap.MoneyWayBank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
