package com.tr.obss.WebApp.controller;


import com.tr.obss.WebApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("/")
    public String getTestData() {

        //model.addAttribute("name", "alli");
        return "test";
    }

    @PostMapping("/")
    public User fetchTestData(@RequestBody User user) {

        return user;
    }

}


