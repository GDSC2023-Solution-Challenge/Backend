package com.findby.post;

import com.findby.image.Image;
import com.findby.orphan.Orphan;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long postId;

    public String password;

    public String title;

    public String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orphan_id")
    public Orphan orphan;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Image> images = new ArrayList<>();

    public LocalDateTime createAt;

    public LocalDateTime updateAt;

    public Boolean isDone;

    public String email;

    public Post(String password, String title, String content, Orphan orphan, List<String> images, LocalDateTime createAt, LocalDateTime updateAt, Boolean isDone, String email) {
        this.password = password;
        this.title = title;
        this.content = content;
        this.orphan = orphan;
        this.images = images.stream().map((url) -> Image.of(url, this)).collect(Collectors.toList());
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.isDone = isDone;
        this.email = email;
    }

    public static Post of(
            String password,
            String title,
            String content,
            String email,
            Orphan orphan,
            List<String> images
    ) {
        return new Post(
                password, title, content, orphan, images, LocalDateTime.now(), LocalDateTime.now(), false, email
        );
    }
}
