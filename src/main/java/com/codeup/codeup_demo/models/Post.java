package com.codeup.codeup_demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "body", columnDefinition = "TEXT", length = 3000, nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User owner;

    public Post(){

    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }
    public Post(String title, String body, User owner){
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(Long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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
