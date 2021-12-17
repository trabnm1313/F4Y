package com.example.projectview.chat;

import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.messages.MessageListItem;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
public class Message implements Serializable {

    @Id
    String _id;
    String userID;
    String topic;
    String text;
    Instant timeStamp;

    public Message() {
    }

    public Message(String _id, String userID, String topic, String text, Instant timeStamp) {
        this._id = _id;
        this.userID = userID;
        this.topic = topic;
        this.text = text;
        this.timeStamp = timeStamp;
    }
}