package com.findby.post.service;

import com.findby.image.Image;
import com.findby.orphan.Orphan;
import com.findby.orphan.service.dtos.OrphanResponse;
import com.findby.post.Post;
import com.findby.post.PostRepository;
import com.findby.post.service.dtos.PostRequest;
import com.findby.post.service.dtos.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostResponse create(PostRequest request) {
        Orphan orphan = Orphan.builder()
                .name(request.getName())
                .age(request.getAge())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .gender(request.getGender())
                .look(request.getLook())
                .countryCode(request.getCountryCode())
                .countryName(request.getCountryName()).build();

        Post post = Post.of(
                request.getPassword(), request.getTitle(), request.getContent(), request.getEmail(), orphan, request.getImageUrls()
        );
        postRepository.save(post);
        OrphanResponse orphanResponse = OrphanResponse.of(
                orphan.getOrphanId(), orphan.getName(), orphan.getAge(), orphan.getLatitude(), orphan.getLongitude(), orphan.getGender(), orphan.getLook(), orphan.getCountryCode(), orphan.getCountryName()
        );
        return PostResponse.of(
                post.getPostId(), post.getTitle(), post.getContent(), post.getEmail(), post.getImages().stream().map(Image::getUrl).collect(Collectors.toList()), post.getIsDone(), post.getCreateAt(), post.getUpdateAt(), orphanResponse
        );
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
