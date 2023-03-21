package com.example.phonebookwebapp.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Nonnull
    private String name;
    @ElementCollection
    private List<String> phoneNum;
    @ElementCollection
    private List<String> email;
    @Column(nullable = true)
    private String dob;

    public Contact(int id, String name, List<String> phoneNum, List<String> email, String Dob) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.dob = Dob;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(List<String> phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String DOB) {
        this.dob = DOB;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum=" + phoneNum +
                ", email=" + email +
                ", DOB='" + dob + '\'' +
                '}';
    }
}
