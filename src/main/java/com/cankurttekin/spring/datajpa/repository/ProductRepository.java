package com.cankurttekin.spring.datajpa.repository;

import com.cankurttekin.spring.datajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByAvailability(boolean availability);
}
