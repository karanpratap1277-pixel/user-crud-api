package com.example.userdemo.controller;

import com.example.userdemo.entity.User;
import com.example.userdemo.repository.UserRepository;
import com.example.userdemo.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }
    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return service.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PutMapping ("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User user){
        return service.updateUser(id,user);
    }

    @DeleteMapping ("/{id}")
    public void deleteUser (@PathVariable Long id){
        service.deleteUser(id);
    }
}