package com.tr.obss.CompanyApp.controller;

import com.tr.obss.CompanyApp.entity.User;
import com.tr.obss.CompanyApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {

        return userService.getUserByName(name);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        return userService.addUser(user);
    }


}
