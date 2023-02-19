package com.findby.post;

import com.findby.orphan.Orphan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long postId;

    public String password;

    public String title;

    public String content;

    @OneToOne
    @JoinColumn(name = "orphan_id")
    public Orphan orphan;

    public LocalDateTime createAt;

    public LocalDateTime updateAt;

    public Boolean isDone;

    public String email;
}
