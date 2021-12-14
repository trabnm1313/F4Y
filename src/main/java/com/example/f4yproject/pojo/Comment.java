package com.example.f4yproject.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("Comment")
public class Comment implements Serializable {

    @Id
    String _id;
    String ThreadID;
    String ownerID;
    String message;
    Boolean isEdited;
    Date timeStamp;

    public Comment(String _id, String threadID, String ownerID, String message, Boolean isEdited, Date timeStamp) {
        this._id = _id;
        ThreadID = threadID;
        this.ownerID = ownerID;
        this.message = message;
        this.isEdited = isEdited;
        this.timeStamp = timeStamp;
    }

}
