package com.example.demo.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "studentinfo")  // Ensure this matches your actual DB table name
public class Login {

    @Id
    @Column(name = "roll_no", nullable = false)
    private String rollNo;

    @Column(name = "mobile_no", nullable = false)
    private String mobileNo;

    // Constructors, getters, and setters
    public Login() {}

    public Login(String rollNo, String mobileNo) {
        this.rollNo = rollNo;
        this.mobileNo = mobileNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
