package com.fiap.MoneyWayBank.repository;

import com.fiap.MoneyWayBank.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
