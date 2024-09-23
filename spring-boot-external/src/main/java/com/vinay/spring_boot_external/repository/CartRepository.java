package com.vinay.spring_boot_external.repository;

import com.vinay.spring_boot_external.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
