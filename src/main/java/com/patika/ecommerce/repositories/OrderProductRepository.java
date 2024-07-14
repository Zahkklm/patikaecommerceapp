package com.patika.ecommerce.repositories;

import com.patika.ecommerce.model.OrderProduct;
import com.patika.ecommerce.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
