package com.cankurttekin.spring.datajpa.service;

import com.cankurttekin.spring.datajpa.entity.Product;
import com.cankurttekin.spring.datajpa.exception.ProductNotFoundException;
import com.cankurttekin.spring.datajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepository) {
        productRepository = theProductRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int theId) {
        /*
        Optional<Product> result = productRepository.findById(theId);
        Product theProduct = null;
        if (result.isPresent()) {
            theProduct = result.get();
        } else {
            throw new RuntimeException("Didn't find product id - " + theId);
        }
        return theProduct;
*/
        return productRepository.findById(theId).orElseThrow(() ->
                new ProductNotFoundException("Product id not found - " + theId));
    }

    @Override
    public Product save(Product theProduct) {
        return productRepository.save(theProduct);
    }

    @Override
    public void deleteById(int theId) {
        productRepository.deleteById(theId);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findByAvailability(boolean availability) {
        return productRepository.findByAvailability(availability);

    }


}
