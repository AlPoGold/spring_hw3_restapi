package com.example.gb.controllers;

import com.example.gb.domain.User;
import com.example.gb.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
//        service.getDataProcessingService().getRepository().getUsers().add(user);
        service.progressRegistration(user.getName(), user.getAge(),user.getEmail());
        return "User added from body!";
    }
}
