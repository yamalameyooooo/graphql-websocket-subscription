package com.shamsuddin.pushnotificationdemo.types;

public class TextMessage {

    private String id;
    private String body;

    public TextMessage(String id, String body) {
        this.id = id;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public TextMessage() {
    }
}
