package com.vinay.spring_boot_external.service;

import com.vinay.spring_boot_external.entity.Cart;
import com.vinay.spring_boot_external.entity.CartItem;
import com.vinay.spring_boot_external.entity.Product;
import com.vinay.spring_boot_external.exception.CartNotFoundException;
import com.vinay.spring_boot_external.exception.ProductNotFoundException;
import com.vinay.spring_boot_external.repository.CartRepository;
import com.vinay.spring_boot_external.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException("Cart not found with id : " + id));
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public String delete(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if(cart.isPresent())
            cartRepository.deleteById(id);
        else
            throw new CartNotFoundException("Cart not found with id : " + id);
        return "Cart with id " + id + " deleted successfully";
    }

    @Override
    public Cart addProductToCart(Long cartId, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart not found with id : " + cartId));
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id : " + productId));

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
    }

    @Override
    public Cart removeProductFromCart(Long cartId, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart not found with id : " + cartId));

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            if (item.getQuantity() <= quantity) {
                cart.getItems().remove(item);
            } else {
                item.setQuantity(item.getQuantity() - quantity);
            }
        } else {
            throw new ProductNotFoundException("Product not found in cart with id : " + productId);
        }

        return cartRepository.save(cart);
    }
}
