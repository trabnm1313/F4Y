package com.example.f4yproject.pojo;

import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.messages.MessageListItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Document("Message")
public class Message implements Serializable {

    @Id
    String _id;
    String userID;
    String topic;
    String text;
    Instant timeStamp;

    public Message(String _id, String userID, String topic, String text, Instant timeStamp) {
        this._id = _id;
        this.userID = userID;
        this.topic = topic;
        this.text = text;
        this.timeStamp = timeStamp;
    }
}
