package com.example.ecomerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@MappedSuperclass
public class Personal{

    @Column(length = 100, nullable = false)
    private String fullName;

    @Column(length = 100)
    private String address;

    @Column(length = 15)
    private String phoneNumber;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 10)
    private String gender;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Must be date of past")
    private LocalDate birthDate;

    public Personal() {
        // TODO Auto-generated constructor stub
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
