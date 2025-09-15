package com.fiap.MoneyWayBank.repository;

import com.fiap.MoneyWayBank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
