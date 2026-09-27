package com.example.userdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table (name="users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Name is required")
    private String name;

    @NotBlank (message = "Email is required")
    @Email (message = "Enter a valid email")
    @Column(unique = true)
    private String email;

    @NotBlank(message="Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$",message="Mobile number must contain 10 digit")
    private String mobile;

    public User(){

    }

    public User(Long id, String name, String email, String mobile){
        this.id=id;
        this.name=name;
        this.email=email;
        this.mobile=mobile;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}