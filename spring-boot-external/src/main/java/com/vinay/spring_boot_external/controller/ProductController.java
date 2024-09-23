package com.vinay.spring_boot_external.controller;

import com.vinay.spring_boot_external.entity.Product;
import com.vinay.spring_boot_external.service.ProductService;
import com.vinay.spring_boot_external.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.PRODUCT_BASE)
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getALlProducts(){
        return productService.findAll();
    }

    @GetMapping(Constants.PRODUCT_ID)
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping(Constants.PRODUCT_ID)
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping(Constants.PRODUCT_ID)
    public String deleteProduct(@PathVariable Long id){
        return productService.delete(id);
    }
}
