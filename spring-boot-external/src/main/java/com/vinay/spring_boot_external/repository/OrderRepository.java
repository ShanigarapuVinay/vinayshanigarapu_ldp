package com.vinay.spring_boot_external.repository;

import com.vinay.spring_boot_external.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
