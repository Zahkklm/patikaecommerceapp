package com.patika.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final String email;
    private final int age;
    
    public Users() {
        this.name = "";
        this.email = "";
        this.age = 0;
    }
    

    public Users(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", age=" + age +'}';
    }
}
