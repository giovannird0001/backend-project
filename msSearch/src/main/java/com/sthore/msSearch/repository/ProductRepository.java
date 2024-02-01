package com.sthore.msSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sthore.msSearch.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
 
}