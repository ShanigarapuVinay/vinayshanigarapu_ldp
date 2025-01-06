package com.vinay.spring_boot_external.service;

import com.vinay.spring_boot_external.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    Cart findById(Long id);
    Cart save(Cart cart);
    String delete(Long id);
    Cart addProductToCart(Long cartId, Long productId, Integer quantity);
    Cart removeProductFromCart(Long cartId, Long productId, Integer quantity);
}
