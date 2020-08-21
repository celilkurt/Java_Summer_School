package com.tr.obss.JpaApp.controller;


import com.tr.obss.JpaApp.entity.User;
import com.tr.obss.JpaApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public  ResponseEntity<List<User>> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public  ResponseEntity<User> getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<List<User>> getUserByName(@PathVariable String name) {

        return userService.getUserByName(name);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        return userService.addUser(user);
    }

    @GetMapping("/appname")
    public ResponseEntity<String> getAppName(){

        return userService.getAppName();
    }

    @GetMapping("/username-and-email")
    public ResponseEntity<Optional<List<User>>> getUserByEmailAndUsername(@RequestParam String email,@RequestParam String username){

       return userService.getUserByEmailAndUsername(email, username);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){

        return userService.deleteUserById(id);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity<User> updateUserAge(@PathVariable Long id,@RequestParam int newAge){

        return userService.updateUserAge(id,newAge);
    }


    @GetMapping("/namedQuery")
    public ResponseEntity<List<User>> getUsersWithNamedQuery(@RequestBody User user){

        return userService.getUsersWithNamedQuery(user.getUsername(),user.getEmail(),user.getAge());

    }

    @PostMapping("/add-all")
    public ResponseEntity<List<User>> addAllUsers(@RequestBody List<User> users){

        return userService.addAllUsers(users);

    }


}
