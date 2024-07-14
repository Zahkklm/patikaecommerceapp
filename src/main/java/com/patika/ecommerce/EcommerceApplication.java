package com.patika.ecommerce;

import com.patika.ecommerce.entities.Users;
import com.patika.ecommerce.model.Order;
import com.patika.ecommerce.model.OrderProduct;
import com.patika.ecommerce.model.Product;
import com.patika.ecommerce.repositories.UserRepository;
import com.patika.ecommerce.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.patika.ecommerce.service.ProductService;
import com.patika.ecommerce.service.OrderService;
import com.patika.ecommerce.service.OrderProductService;

import java.util.stream.Stream;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("Ozgur", "Ahmet", "Selim", "Cem", "Cem").forEach(name -> {
                Users user = new Users(name, name.toLowerCase() + "@gmail.com", 27);
                userRepository.save(user);
            });
            Users user1 = new Users("Cem", "cem@gmail.com", 22);
            Users user2 = new Users("Cem", "cem@gmail.com", 18);
            userRepository.save(user1);
            userRepository.save(user2);

            userRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Kitap", 85.0));
            productService.save(new Product(2L, "Pantolon", 300.0));
            productService.save(new Product(3L, "Masa", 700.0));
            productService.save(new Product(4L, "Laptop", 25000.0));
            productService.save(new Product(5L, "Kamera", 5000.0));
        };
    }

    @Bean
    CommandLineRunner runner(OrderProductService orderProductService, ProductService productService) {
        return args -> {
            Product pr = productService.getProduct(1L);
            OrderProduct op = new OrderProduct(new Order(), pr, 10);
            orderProductService.create(op);
            System.out.println(op);
        };
    }

    @Bean
    CommandLineRunner runner(OrderProductService orderProductService, ProductService productService, UserRepository userRepository, UserService userService) {
        return args -> {
            long prCemBought = userService.getAllUsers().stream().peek(System.out::println).filter(user -> user.name.equals("Cem"))
                    .toList();
            long cemNumbers = userService.getAllUsers().stream().peek(System.out::println).filter(user -> user.name.equals("Cem"))
                    .count();
            long under1500 = userService.getAllUsers().stream().peek(System.out::println).filter(product -> product.price < 1500.0);
            System.out.println("Cemin aldığı ürün miktarı: " + prCemBought);
            System.out.println("Cem isimli müşteriler: " + cemNumbers);
            System.out.println("Cem isimli müşteriler: " + under1500);
        };
    }



}
