package com.codeup.codeup_demo.models;

public class Post {
    private String title;
    private String body;

    Post(){

    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }
    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
