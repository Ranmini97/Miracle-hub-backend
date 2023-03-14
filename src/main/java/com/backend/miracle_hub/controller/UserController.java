package com.backend.miracle_hub.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @GetMapping("/getUser")
    public String getUser(){
        return "This is my miracle hub.... :)";
    }

    @PostMapping("/saveUser")
    public String saveUser(){
        return "User Saved!";
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "User Updated!";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "User Deleted!";
    }
}
