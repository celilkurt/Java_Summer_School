package com.tr.obss.WebApp.controller;


import com.tr.obss.WebApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping
    public @ResponseBody String getTestData() {
        return "test";
    }

    @PostMapping
    public @ResponseBody String fetchTestData(@RequestBody User user) {

        return user.toString();
    }

}


