package com.patika.ecommerce.repositories;

import com.patika.ecommerce.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
