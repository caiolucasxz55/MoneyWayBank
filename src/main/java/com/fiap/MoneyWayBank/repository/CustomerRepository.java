package com.fiap.MoneyWayBank.repository;

import com.fiap.MoneyWayBank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCpf(String cpf);
}
