package com.patika.ecommerce.service;

import com.patika.ecommerce.model.Product;
import com.patika.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository
            .findById(id).orElse(null);
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }
}
