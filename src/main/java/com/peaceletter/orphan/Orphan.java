package com.peaceletter.orphan;

import com.peaceletter.post.Post;

import javax.persistence.*;

@Entity
public class Orphan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long orphanId;

    public String name;

    public Integer age;

    public String missedLocation;

    public String sex;

    public String look;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId")
    public Post post;
}
