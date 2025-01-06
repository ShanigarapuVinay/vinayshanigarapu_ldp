package com.vinay.spring_boot_external.service;

import com.vinay.spring_boot_external.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Long id, Product newProduct);
    String delete(Long id);
}
