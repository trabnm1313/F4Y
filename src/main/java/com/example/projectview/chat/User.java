package com.example.projectview.chat;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("User")
public class User implements Serializable {

    @Id
    String _id;
    String username;
    String password;
    String nickname;
    String description;

    public User() {}

    public User(String _id, String username, String password, String nickname, String description) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.description = description;
    }

}
