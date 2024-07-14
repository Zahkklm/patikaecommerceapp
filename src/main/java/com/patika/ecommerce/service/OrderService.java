package com.patika.ecommerce.service;

import com.patika.ecommerce.model.Order;
import com.patika.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
