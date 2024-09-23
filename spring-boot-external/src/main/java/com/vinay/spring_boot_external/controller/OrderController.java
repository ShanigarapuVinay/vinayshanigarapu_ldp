package com.vinay.spring_boot_external.controller;

import com.vinay.spring_boot_external.entity.Order;
import com.vinay.spring_boot_external.service.OrderService;
import com.vinay.spring_boot_external.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.ORDER_BASE)
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.findAll();
    }

    @GetMapping(Constants.ORDER_ID)
    public Order getOrderById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping(Constants.SAVE_CART)
    public Order createOrderFromCart(@PathVariable Long cartId) {
        return orderService.createOrderFromCart(cartId);
    }

    @DeleteMapping(Constants.ORDER_ID)
    public String cancelOrder(@PathVariable Long id){
        return orderService.delete(id);
    }
}
