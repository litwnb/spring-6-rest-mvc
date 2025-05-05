package com.litwnb.spring6restmvc.repository;

import com.litwnb.spring6restmvc.domain.BeerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
}
