package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class HelloController {
    @PostMapping("/send")
    public ResponseEntity<String> receiveData(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        return ResponseEntity.ok("Hello, " + name + "!");
    }


}
