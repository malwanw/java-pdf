package com.mandiri.entity;

import javax.persistence.*;

@Entity
@Table(name="user_bio")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nik;
    private String address;
    private String email;
    private String phone;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNik() {
        return nik;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
