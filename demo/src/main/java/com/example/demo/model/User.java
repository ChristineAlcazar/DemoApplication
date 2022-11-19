package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private int id;
    private String full_name;
    private String email_address;
    private String mobile_number;
    private String date_of_birth;
    private int age;
    private String gender;

    public User() {
    }

    public User(int id, String full_name, String email_address, String mobile_number, String date_of_birth, int age, String gender) {
        this.id = id;
        this.full_name = full_name;
        this.email_address = email_address;
        this.mobile_number = mobile_number;
        this.date_of_birth = date_of_birth;
        this.age = age;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "full_name")
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Column(name = "email_address")
    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    @Column(name = "mobile_number")
    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    @Column(name = "date_of_birth")
    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}