package com.findby.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long postId;

    public String password;

    public String title;

    public String content;

    public LocalDateTime createAt;

    public LocalDateTime updateAt;

    public Boolean isDone;

    public String email;
}
