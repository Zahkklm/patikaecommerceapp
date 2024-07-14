package com.patika.ecommerce.repositories;

import com.patika.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
