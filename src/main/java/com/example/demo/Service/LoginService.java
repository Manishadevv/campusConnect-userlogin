package com.example.demo.Service;


import com.example.demo.Domain.Login;
import com.example.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    public Login login(String rollNo, String password) {
        System.out.println("Received rollNo: " + rollNo);
        System.out.println("Received mobileNo: " + password);

        Login user = repo.findByRollNoAndMobileNo(rollNo, password);

        if (user != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }

        return user;
    }
}
