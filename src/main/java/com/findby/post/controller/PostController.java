package com.findby.post.controller;

import com.findby.common.CommonResponse;
import com.findby.common.swagger.post.PostCreate;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "posts", description = "게시물 API")
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @PostCreate
    @PostMapping("")
    public ResponseEntity<CommonResponse<PostResponse>> create(
            @RequestBody PostRequest postRequest
    ) {
        CommonResponse<PostResponse> response = new CommonResponse<>(HttpStatus.CREATED, "피스레터 생성이 완료되었습니다.", PostResponse.API_TEST());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
