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
    String ownerID;
    String topic;
    String message;
    Integer like;
    Boolean isEdited;
    Date timeStamp;
    String tag;

    public Thread(String _id, String ownerID, String topic, String message, Integer like, Boolean isEdited, Date timeStamp, String tag) {
        this._id = _id;
        this.ownerID = ownerID;
        this.topic = topic;
        this.message = message;
        this.like = like;
        this.isEdited = isEdited;
        this.timeStamp = timeStamp;
        this.tag = tag;
    }
}
