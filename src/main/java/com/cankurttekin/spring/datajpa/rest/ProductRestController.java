package com.cankurttekin.spring.datajpa.rest;

import com.cankurttekin.spring.datajpa.entity.Product;
import com.cankurttekin.spring.datajpa.exception.ProductNotFoundException;
import com.cankurttekin.spring.datajpa.service.ProductService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product theProduct = productService.findById(productId);
        if (theProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        return theProduct;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product theProduct) {
        theProduct.setId(0);
        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestBody Product theProduct) {
        Product tempProduct = productService.findById(productId);

        if (tempProduct == null) {
            throw new ProductNotFoundException("Product id not found - " + theProduct.getId());
        }
        theProduct.setId(productId);
        //Product dbProduct = productService.save(theProduct);
        //return dbProduct;
        return new ResponseEntity<>(productService.save(theProduct), HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.findById(productId);

        // throw exc if null
        if (tempProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }

        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllProducts() {
        try {
            productService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/products/available")
    public List<Product> findAllAvailable() {
        List<Product> availableProducts = productService.findByAvailability(true);
        return availableProducts;
    }

}
