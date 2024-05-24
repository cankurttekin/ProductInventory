package com.cankurttekin.spring.datajpa.service;

import com.cankurttekin.spring.datajpa.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int theId);
    Product save(Product theProduct);
    void deleteById(int theId);
    void deleteAll();
    List<Product> findByAvailability(boolean availability);
}
