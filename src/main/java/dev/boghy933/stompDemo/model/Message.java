package dev.boghy933.stompDemo.model;

public class Message {
    private String message;

    public Message(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
