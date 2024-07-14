package com.patika.ecommerce.service;

import com.patika.ecommerce.entities.Users;
import com.patika.ecommerce.model.Product;
import com.patika.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }


    public Users save(Users user) {
        return userRepository.save(user);
    }
}
