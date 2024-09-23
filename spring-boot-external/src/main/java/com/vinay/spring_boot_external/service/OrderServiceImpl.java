package com.vinay.spring_boot_external.service;

import com.vinay.spring_boot_external.entity.Cart;
import com.vinay.spring_boot_external.entity.CartItem;
import com.vinay.spring_boot_external.entity.Order;
import com.vinay.spring_boot_external.entity.OrderItem;
import com.vinay.spring_boot_external.exception.CartNotFoundException;
import com.vinay.spring_boot_external.exception.OrderNotFoundException;
import com.vinay.spring_boot_external.repository.CartRepository;
import com.vinay.spring_boot_external.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private CartRepository cartRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found with id : " + id));
    }

    @Override
    public Order createOrderFromCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart not found with id : " + cartId));
        Order order = new Order();

        for (CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
            order.getItems().add(orderItem);
        }

        updateOrderTotals(order);
        return orderRepository.save(order);
    }

    private void updateOrderTotals(Order order) {
        int totalQuantity = 0;
        double totalPrice = 0.0;

        for (OrderItem item : order.getItems()) {
            totalQuantity += item.getQuantity();
            totalPrice += item.getPrice();
        }

        order.setTotalQuantity(totalQuantity);
        order.setTotalPrice(totalPrice);
    }

    @Override
    public String delete(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent())
            orderRepository.deleteById(id);
        else
            throw new OrderNotFoundException("Order not found with id : " + id);
        return "Order with id " + id + " cancelled successfully";
    }
}
