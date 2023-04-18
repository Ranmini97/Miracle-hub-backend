package com.backend.miracle_hub.controller;

import com.backend.miracle_hub.dto.LoginDTO;
import com.backend.miracle_hub.service.LoginService;
import com.backend.miracle_hub.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/login")
@CrossOrigin("http://localhost:3000")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/saveLoginDetails")
    public ResponseEntity<String> saveLoginDetails(@RequestBody LoginDTO loginDTO) {
        loginService.saveLogin(loginDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Login details saved successfully");
    }

    @PutMapping("/updateLoginDetails")
    public ResponseEntity<String> updateLoginDetails(@RequestBody LoginDTO loginDTO) {
        loginService.updateLogin(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Login details updated successfully");
    }

    @GetMapping("/getAllLoginDetails")
    public ResponseEntity<?> getAllLoginDetails() {
        return ResponseEntity.ok(loginService.getAllLoginDetails());
    }

    @DeleteMapping("/deleteLoginDetails")
    public ResponseEntity<String> deleteLoginDetails(@RequestBody LoginDTO loginDTO) {
        if (loginService.deleteLogin(loginDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body("Login details deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the login details");
        }
    }

    @PostMapping("/validateUser")
    public ResponseEntity<?> validateUser(@RequestBody LoginDTO loginDTO) {
        try {
            boolean isValid = loginService.validateUser(loginDTO);
            if (isValid) {
                return ResponseEntity.ok("Login Successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}