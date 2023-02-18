package com.findby.post.service;

import java.util.List;

public interface PostService {
    PostResponse create(PostRequest request);
    PostRequest getPost(Long postId);
    void delete(Long postId, String password);
    void end(Long postId, String password);
    List<PostResponse> getPosts (String... TBU);
}
