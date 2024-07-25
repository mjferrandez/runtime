package com.runtime.runtime.controller;


import com.runtime.runtime.model.Distance;
import com.runtime.runtime.model.Pace;
import com.runtime.runtime.model.TotalTime;
import com.runtime.runtime.model.User;
import com.runtime.runtime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Métodos de la API REST para CRUD

    // Ejemplo de método para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Ejemplo de método para obtener un usuario por su ID
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Ejemplo de método para crear un nuevo usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Ejemplo de método para actualizar un usuario existente
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    // Ejemplo de método para eliminar un usuario por su ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }



}

