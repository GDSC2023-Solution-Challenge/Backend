package com.findby.post.service;

import com.findby.post.service.dtos.PostRequest;
import com.findby.post.service.dtos.PostResponse;
import com.findby.post.service.dtos.PostUpdate;

import java.util.List;

public interface PostService {
    PostResponse create(PostRequest request);
    PostResponse getPost(Long postId);
    void delete(Long postId, String password);
    void end(Long postId, String password);
    List<PostResponse> getPosts (String... TBU);
    PostResponse update(Long postId, PostUpdate postUpdate);
}
