package com.litwnb.spring6restmvc.repository;

import com.litwnb.spring6restmvc.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
