package com.example.projectview.view.main;

public class Person {

    private String _id;
    private String username;
    private String password;
    private String nickname;
    private String description;
    private String date;

    public Person() {
    }

    public Person(String _id, String username, String password, String nickname, String description, String date) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.description = description;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}