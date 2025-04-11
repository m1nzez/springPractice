package com.example.springpractice.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class PostCommentRequestDto {
    private Long articleId;
    private String content;
}
