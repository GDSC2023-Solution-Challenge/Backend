package com.findby.post.controller;

import com.findby.common.CommonResponse;
import com.findby.common.swagger.post.*;

import com.findby.post.service.PostService;
import com.findby.post.service.dtos.PostRequest;
import com.findby.post.service.dtos.PostResponse;
import com.findby.post.service.dtos.PostUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "posts", description = "피스레터 API")
@RestController
@RequestMapping("api/v1/post")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetPost
    @GetMapping("{postId}")
    public ResponseEntity<CommonResponse<PostResponse>> get(
            @PathVariable("postId") Long postId
    ) {
        PostResponse postResponse = postService.getPost(postId);
        CommonResponse<PostResponse> response = new CommonResponse<>(HttpStatus.OK, "피스레터 조회를 성공하였습니다.", postResponse);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @CreatePost
    @PostMapping("")
    public ResponseEntity<CommonResponse<PostResponse>> create(
            @RequestBody PostRequest postRequest
    ) {
        PostResponse postResponse = postService.create(postRequest);
        CommonResponse<PostResponse> response = new CommonResponse<>(HttpStatus.CREATED, "피스레터 생성이 완료되었습니다.", postResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @EndPost
    @PatchMapping("{postId}/end")
    public ResponseEntity<CommonResponse<Object>> end(
            @PathVariable("postId") Long postId,
            @RequestParam("password") String password
    ) {
        Map<String, Object> result = Map.of(
                "peaceletterId", 1,
                "isDone", true
        );
        CommonResponse<Object> response = new CommonResponse<>(HttpStatus.OK, "피스레터 종료가 완료되었습니다.", result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @UpdatePost
    @PutMapping("{postId}")
    public ResponseEntity<CommonResponse<PostResponse>> update(
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdate postUpdate
    ) {
        PostResponse postResponse = postService.update(postId, postUpdate);
        CommonResponse<PostResponse> response = new CommonResponse<>(HttpStatus.OK, "피스레터 수정이 완료되었습니다.", postResponse);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeletePost
    @DeleteMapping("{postId}")
    public ResponseEntity<CommonResponse<Object>> delete(
            @PathVariable("postId") Long postId,
            @RequestParam("password") String password
    ) {
        postService.delete(postId, password);
        CommonResponse<Object> response = new CommonResponse<>(HttpStatus.OK, "피스레터 삭제가 완료되었습니다.", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetAchievements
    @GetMapping("/achievements")
    public ResponseEntity<CommonResponse<Object>> getAchievements(){
        Map<String, Integer> achievements = Map.of("findedPerson", 5);
        CommonResponse<Object> response = new CommonResponse<>(HttpStatus.OK, "조회를 성공하였습니다.", achievements);
        return ResponseEntity.status(HttpStatus.OK).body(response); 
    }
}
