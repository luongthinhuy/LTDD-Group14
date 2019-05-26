package com.example.myapplication;

public class User {
    private String username;
    private String password;
    private String image;
    private String name;
    private String phone;
    private int gender;

    public User(String username, String password, String image, String name, String phone, int gender) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
