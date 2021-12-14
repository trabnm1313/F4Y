package com.example.f4yproject.pojo;

import com.vaadin.collaborationengine.CollaborationMessageList;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Message")
public class Message implements Serializable {

    @Id
    String _id;
    String topic;
    CollaborationMessageList messageList;

    public Message(String _id, String topic, CollaborationMessageList messageList) {
        this._id = _id;
        this.topic = topic;
        this.messageList = messageList;
    }

}
