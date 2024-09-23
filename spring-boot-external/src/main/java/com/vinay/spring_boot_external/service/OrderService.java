package com.vinay.spring_boot_external.service;

import com.vinay.spring_boot_external.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Long id);
    Order createOrderFromCart(Long cartId);
    String delete(Long id);
}
