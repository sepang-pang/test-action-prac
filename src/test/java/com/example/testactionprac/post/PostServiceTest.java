package com.example.testactionprac.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Transactional // 롤백시키기 위한 어노테이션
class PostServiceTest {

    @Mock
    PostRepository postRepository;

    // requestDto로 만든 Post의 값과 저장된 Post의 값이 일치하는지
    // 테스트 코드 작성

    @Test
    @DisplayName("createPost() 테스트")
    void createPost() {
        // given
        String content = "test_content";

        PostRequestDto requestDto = new PostRequestDto();
        requestDto.setContent(content);

        Post post = new Post(requestDto);

        PostService postService = new PostService(postRepository);

        // when
        PostResponseDto responseDto = postService.createPost(requestDto);

        // then
        assertEquals(responseDto.getContent(),content);

    }

    @Test
    @DisplayName("createPost() 테스트")
    void createPost2() {
        // given
        String content = "test_content";

        PostRequestDto requestDto = new PostRequestDto();
        requestDto.setContent(content);

        Post post = new Post(requestDto);

        PostService postService = new PostService(postRepository);

        // when
        PostResponseDto responseDto = postService.createPost(requestDto);

        // then
        assertEquals(responseDto.getContent(),"content");

    }
}