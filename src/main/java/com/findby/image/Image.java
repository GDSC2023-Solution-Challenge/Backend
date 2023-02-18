package com.findby.image;

import com.findby.post.Post;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long imageId;

    public String url;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId")
    public Post post;
}
