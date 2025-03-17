package com.example.httpMethods.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/home")
    public String gethome(){
       return "home";
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("ashwin", "anshuman", "mitu");
    }

    @PostMapping("/createUser")
    public String createUser(){
        return "User created";
    }


}

