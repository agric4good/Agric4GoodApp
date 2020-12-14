package com.bumie.agric4good;

public class Users {
    public String jwt;
    String name;

    public Users(String name, String jwt) {
        this.name = name;
        this.jwt = jwt;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return jwt;
    }
}
