package com.vinay.spring_boot_external.service;

import com.vinay.spring_boot_external.entity.Product;
import com.vinay.spring_boot_external.exception.ProductNotFoundException;
import com.vinay.spring_boot_external.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id : " + id));
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long id, Product newProduct){
        Optional<Product> updatedProduct = repository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            return repository.save(product);
        });
        if(updatedProduct.isPresent())
            return updatedProduct.get();
        else
            throw new ProductNotFoundException("Product not found with id : " + id);
    }

    @Override
    public String delete(Long id) {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent())
            repository.deleteById(id);
        else
            throw new ProductNotFoundException("Product not found with id : " + id);
        return "Product with id " + id + " deleted successfully";
    }
}
