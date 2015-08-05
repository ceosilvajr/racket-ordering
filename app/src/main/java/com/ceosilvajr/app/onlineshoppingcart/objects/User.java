package com.ceosilvajr.app.onlineshoppingcart.objects;

/**
 * Created by ceosilvajr on 8/1/15.
 */
public class User {

    private String username;

    private String email;

    private String password;

    public User (){

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
