package com.example.demo.Controller;

import com.example.demo.Domain.Login;
import com.example.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // Use REST instead of Thymeleaf templates
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Allow Flutter to access the API
public class LoginController {

    @Autowired
    private LoginService userService;

    @PostMapping("/login")
    public ResponseEntity<?> processLogin(@RequestBody Login user) {
        Login oauthUser = userService.login(user.getRollNo(), user.getMobileNo());

        if (oauthUser != null) {
            return ResponseEntity.ok(oauthUser); // Return JSON response
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
