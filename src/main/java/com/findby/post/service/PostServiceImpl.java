package com.findby.post.service;

import com.findby.common.exception.BadRequestException;
import com.findby.common.exception.ForbiddenException;
import com.findby.image.Image;
import com.findby.orphan.Orphan;
import com.findby.orphan.service.OrphanService;
import com.findby.orphan.service.dtos.OrphanResponse;
import com.findby.orphan.service.dtos.OrphanUpdate;
import com.findby.post.Post;
import com.findby.post.PostRepository;
import com.findby.post.service.dtos.PostRequest;
import com.findby.post.service.dtos.PostResponse;
import com.findby.post.service.dtos.PostUpdate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final OrphanService orphanService;

    @Override
    @Transactional
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
        return getPostResponse(post, orphan);
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

    @Override
    @Transactional
    public PostResponse update(Long postId, PostUpdate postUpdate) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(() -> new BadRequestException("해당 피스레터가 존재하지 않습니다."));

        isWriter(post, postUpdate.getPassword());
        PostRequest request = postUpdate.getPostRequest();
        OrphanUpdate orphanUpdate = new OrphanUpdate(request);
        Orphan orphan = orphanService.update(post.getOrphan(), orphanUpdate);
        post.update(
                request.getPassword(),
                request.getTitle(),
                request.getContent(),
                request.getEmail(),
                orphan,
                request.getImageUrls()
        );

        return getPostResponse(post, orphan);
    }

    private void isWriter(Post post, String password) {
        boolean equals = post.getPassword().equals(password);
        if (!equals) {
            throw new ForbiddenException("해당 피스레터를 수정할 수 있는 권한이 존재하지 않습니다.");
        }
    }

    private PostResponse getPostResponse(Post post, Orphan orphan) {
        OrphanResponse orphanResponse = OrphanResponse.of(
                orphan.getOrphanId(), orphan.getName(), orphan.getAge(), orphan.getLatitude(), orphan.getLongitude(), orphan.getGender(), orphan.getLook(), orphan.getCountryCode(), orphan.getCountryName()
        );
        return PostResponse.of(
                post.getPostId(), post.getTitle(), post.getContent(), post.getEmail(), post.getImages().stream().map(Image::getUrl).collect(Collectors.toList()), post.getIsDone(), post.getCreateAt(), post.getUpdateAt(), orphanResponse
        );
    }
}
