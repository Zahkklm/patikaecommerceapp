package com.patika.ecommerce.service;

import com.patika.ecommerce.model.OrderProduct;
import com.patika.ecommerce.repositories.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderProductService  {

    private OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
