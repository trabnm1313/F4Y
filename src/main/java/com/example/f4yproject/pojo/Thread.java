package com.example.f4yproject.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Data
@Document("Thread")
public class Thread implements Serializable {

    @Id
    String _id;
    String topic;
    String message;
    Date timeStamp;

    public Thread(String _id, String topic, String message, Date timeStamp) {
        this._id = _id;
        this.topic = topic;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
