package com.findby.post.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostRequest {
    @Schema(example = "우리 아이를 찾아주세요.")
    private final String title;
    @Schema(example = "블라블라")
    private final String content;
    @Schema(example = "findby@findby.com")
    private final String email;
    @Schema(example = "alice")
    private final String name;
    @Schema(example = "9")
    private final Integer age;
    @Schema(example = "124.1234")
    private final Double latitude;
    @Schema(example = "34.1234")
    private final Double longitude;
    @Schema(example = "female")
    private final String gender;
    @Schema(example = "눈 밑에 점이 있고, 왼쪽 볼에 흉터가 있습니다")
    private final String look;
    @Schema(example = "UA")
    private final String countryCode;
    @Schema(example = "UKRAINE")
    private final String countryName;
    private final List<String> imageUrls;
}
