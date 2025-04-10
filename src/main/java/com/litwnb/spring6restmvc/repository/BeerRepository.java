package com.litwnb.spring6restmvc.repository;

import com.litwnb.spring6restmvc.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
