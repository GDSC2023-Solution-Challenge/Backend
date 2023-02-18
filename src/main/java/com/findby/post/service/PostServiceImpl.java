package com.findby.post.service;

import com.findby.post.service.dtos.PostRequest;
import com.findby.post.service.dtos.PostResponse;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public PostResponse create(PostRequest request) {
        return null;
    }

    @Override
    public PostRequest getPost(Long postId) {
        return null;
    }

    @Override
    public void delete(Long postId, String password) {

    }

    @Override
    public void end(Long postId, String password) {

    }

    @Override
    public List<PostResponse> getPosts(String... TBU) {
        return null;
    }
}
