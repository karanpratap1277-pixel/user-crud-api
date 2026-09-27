package com.example.userdemo.service;

import com.example.userdemo.entity.User;
import com.example.userdemo.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    private UserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new UserService(repository);
    }

    @Test
    void testCreateUser() {

        User user = new User(
                1L,
                "Karan",
                "karan@gmail.com",
                "9876543210"
        );

        when(repository.save(user)).thenReturn(user);

        User result = service.createUser(user);

        assertEquals("Karan", result.getName());
    }

    @Test
    void testGetAllUsers() {

        User user = new User(
                1L,
                "Karan",
                "karan@gmail.com",
                "9876543210"
        );

        when(repository.findAll()).thenReturn(List.of(user));

        List<User> result = service.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("Karan", result.get(0).getName());
    }
    @Test
    void testGetUserById() {

        User user = new User(
                1L,
                "Karan",
                "karan@gmail.com",
                "9876543210"
        );

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User result = service.getUserById(1L);

        assertEquals("Karan", result.getName());
        assertEquals("karan@gmail.com", result.getEmail());
    }
    @Test
    void testUpdateUser() {

        User oldUser = new User(
                1L,
                "Karan",
                "karan@gmail.com",
                "9876543210"
        );

        User newUser = new User(
                1L,
                "Karan Singh",
                "karan123@gmail.com",
                "9999999999"
        );

        when(repository.findById(1L))
                .thenReturn(java.util.Optional.of(oldUser));

        when(repository.save(oldUser))
                .thenReturn(oldUser);

        User result = service.updateUser(1L, newUser);

        assertEquals("Karan Singh", result.getName());
        assertEquals("karan123@gmail.com", result.getEmail());
        assertEquals("9999999999", result.getMobile());
    }
    @Test
    void testDeleteUser() {

        Long userId = 1L;

        service.deleteUser(userId);

        verify(repository).deleteById(userId);
    }
}