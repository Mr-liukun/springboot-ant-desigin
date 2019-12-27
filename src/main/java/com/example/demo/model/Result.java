package com.example.demo.model;

public class Result {
    private String Message;

    private int content;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Message='" + Message + '\'' +
                '}';
    }
}
