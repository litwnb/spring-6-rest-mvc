package com.litwnb.spring6restmvc.repository;

import com.litwnb.spring6restmvc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
