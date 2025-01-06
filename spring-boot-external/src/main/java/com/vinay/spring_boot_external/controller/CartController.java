package com.vinay.spring_boot_external.controller;

import com.vinay.spring_boot_external.entity.Cart;
import com.vinay.spring_boot_external.entity.CartItem;
import com.vinay.spring_boot_external.service.CartService;
import com.vinay.spring_boot_external.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.CART_BASE)
@AllArgsConstructor
public class CartController {

    private CartService cartService;


    @GetMapping
    public List<Cart> getALlCarts(){
        return cartService.findAll();
    }

    @GetMapping(Constants.CART_ID)
    public Cart getCartById(@PathVariable Long id){
        return cartService.findById(id);
    }

    @PostMapping
    public Cart saveCart(@RequestBody Cart cart){
        return cartService.save(cart);
    }

    @DeleteMapping(Constants.CART_ID)
    public String deleteCart(@PathVariable Long id){
        return cartService.delete(id);
    }

    @GetMapping(Constants.CART_ID_PRODUCTS)
    public List<CartItem> getCartItems(@PathVariable Long id){
        Cart cart = cartService.findById(id);
        return cart.getItems();
    }

    @PostMapping(Constants.CART_ID_PRODUCTS_PRODUCT_ID)
    public String addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam Integer quantity) {
        Cart updatedCart = cartService.addProductToCart(cartId, productId, quantity);
        return "Product - " + productId + " is added to Cart of id : " + cartId;
    }

    @DeleteMapping(Constants.CART_ID_PRODUCTS_PRODUCT_ID)
    public Cart removeProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam Integer quantity) {
        return cartService.removeProductFromCart(cartId, productId, quantity);
    }
}
