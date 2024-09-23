package com.vinay.spring_boot_external.repository;

import com.vinay.spring_boot_external.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
