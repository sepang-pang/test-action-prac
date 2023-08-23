package com.example.testactionprac.post;

import lombok.Getter;

@Getter // 테스트용
public class PostResponseDto {
    private Long id;
    private String content;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
    }
}
