package com.example.springpractice.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public class CommentResponseDto {
    private Long articleId;
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private Boolean isLiked;
}