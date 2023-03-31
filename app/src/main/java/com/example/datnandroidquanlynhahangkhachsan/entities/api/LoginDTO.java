package com.example.datnandroidquanlynhahangkhachsan.entities.api;

public class LoginDTO {
    private String userName;
    private String pass;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getpass() {
        return pass;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }

    public LoginDTO() {
        this.userName = "";
        this.pass = "";
    }

    public LoginDTO(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }
}
