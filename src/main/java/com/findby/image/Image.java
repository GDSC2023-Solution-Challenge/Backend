package com.findby.image;

import com.findby.post.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long imageId;

    public String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "postId")
    public Post post;

    private Image(String url, Post post) {
        this.url = url;
        this.post = post;
    }

    public static Image of(String url, Post post) {
        return new Image(url, post);
    }
}
