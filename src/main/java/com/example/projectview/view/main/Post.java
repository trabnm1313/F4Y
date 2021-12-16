package com.example.projectview.view.main;

import java.util.Date;

public class Post {
    private String _id;
    private String ownerID;
    private String topic;
    private String message;
    private Date timeStamp;

    public Post() {
    }

    public Post(String _id, String ownerID, String topic, String message, Date timeStamp) {
        this._id = _id;
        this.ownerID = ownerID;
        this.topic = topic;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
