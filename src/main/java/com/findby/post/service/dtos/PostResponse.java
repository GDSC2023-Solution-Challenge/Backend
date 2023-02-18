package com.findby.post.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostResponse {
    private final Long postId;
    private final String title;
    private final String content;
    private final String email;
    private final String name;
    private final Integer age;
    private final Double latitude;
    private final Double longitude;
    private final String gender;
    private final String look;
    private final String countryCode;
    private final String countryName;
    private final List<String> imageUrls;
    private final Boolean isDone;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;

    public static PostResponse API_TEST() {
        return new PostResponse(
                1L,
                "우리 아이를 찾아주세요.",
                "블라블라",
                "findby@findby.com",
                "alice",
                9,
                124.1234,
                34.1234,
                "female",
                "눈 밑에 점이 있고, 왼쪽 볼에 흉터가 있습니다",
                "UA",
                "UKRAINE",
                List.of(),
                false,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}