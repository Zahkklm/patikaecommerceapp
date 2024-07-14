package com.patika.ecommerce.repositories;

import com.patika.ecommerce.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{}
