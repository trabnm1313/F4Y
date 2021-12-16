package com.example.f4yproject.pojo;

import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document("Message")
public class Message implements Serializable {

    @Id
    String _id;
    String topic;
    List<MessageListItem> messageList;

    public Message(){}

    public Message(String _id, String topic, List<MessageListItem> messageList) {
        this._id = _id;
        this.topic = topic;
        this.messageList = messageList;
    }
}
