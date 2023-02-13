package com.findby.post.controller;

import com.findby.common.CommonResponse;
import com.findby.common.swagger.post.CreatePost;

import com.findby.common.swagger.post.DeletePost;
import com.findby.common.swagger.post.GetPost;
import com.findby.common.swagger.post.UpdatePost;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "posts", description = "피스레터 API")
@RestController
@RequestMapping("api/v1/post")
public class PostController {

    @GetPost
    @GetMapping("{postId}")
    public ResponseEntity<CommonResponse<List<PostResponse>>> get(
            @PathVariable("postId") Long postId
    ) {
        CommonResponse<List<PostResponse>> response = new CommonResponse<>(HttpStatus.OK, "피스레터 조회를 성공하였습니다.", List.of(PostResponse.API_TEST(), PostResponse.API_TEST(), PostResponse.API_TEST()));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @CreatePost
    @PostMapping("")
    public ResponseEntity<CommonResponse<PostResponse>> create(
            @RequestBody PostRequest postRequest
    ) {
        CommonResponse<PostResponse> response = new CommonResponse<>(HttpStatus.CREATED, "피스레터 생성이 완료되었습니다.", PostResponse.API_TEST());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @UpdatePost
    @PutMapping("{postId}")
    public ResponseEntity<CommonResponse<PostResponse>> update(
            @PathVariable("postId") Long postId,
            @RequestBody PostRequest postUpdate
    ) {
        CommonResponse<PostResponse> response = new CommonResponse<>(HttpStatus.OK, "피스레터 수정이 완료되었습니다.", PostResponse.API_TEST());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeletePost
    @DeleteMapping("{postId}")
    public ResponseEntity<CommonResponse<Object>> delete(
            @PathVariable("postId") Long postId
    ) {
        CommonResponse<Object> response = new CommonResponse<>(HttpStatus.OK, "피스레터 삭제가 완료되었습니다.", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
