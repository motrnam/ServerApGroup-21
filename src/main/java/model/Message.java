package model;

import model.enums.MessageEnum;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    private  String senderUsername,text;
    private long time;
    private MessageEnum type;

    public Message(String senderUsername, String text, long time, MessageEnum type) {//for loading from file
        this.senderUsername = senderUsername;
        this.text = text;
        this.time = time;
        this.type = type;
    }

    public Message(String username,String text,MessageEnum type){//for creating new message
        this.senderUsername = username;
        this.text = text;
        this.type = type;
        this.time = System.currentTimeMillis();
    }

    public void setText(String text) {
        this.text = text;
    }
}
