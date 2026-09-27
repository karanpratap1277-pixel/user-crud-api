package com.example.userdemo.service;

import com.example.userdemo.entity.User;
import com.example.userdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser (User user){
        return repository.save(user);
    }

    public List<User>getAllUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user){
        User oldUser=repository.findById(id).orElse(null);

        if (oldUser!=null){
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setMobile(user.getMobile());
            return repository.save(oldUser);
        }
        return null;
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
