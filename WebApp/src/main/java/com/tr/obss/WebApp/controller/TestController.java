package com.tr.obss.WebApp.controller;


import com.tr.obss.WebApp.model.User;
import com.tr.obss.WebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    UserService userService;


    @GetMapping
    public  ResponseEntity<String> getTestData(@RequestParam String message) {

        return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<User> getUser(@PathVariable Long id) {

        User user = userService.getUser(id);

        if(user == null)
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> fetchTestData(@Valid @RequestBody User user, @PathVariable Long id) {

        user.setId(id);
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/appname")
    public ResponseEntity<String> getAppName(){

        return new ResponseEntity<String>(userService.getAppName(),HttpStatus.OK);
    }

}


