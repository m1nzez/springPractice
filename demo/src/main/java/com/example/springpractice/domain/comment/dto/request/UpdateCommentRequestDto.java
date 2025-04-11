package com.example.springpractice.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class UpdateCommentRequestDto {
    private Long commentId;
    private String content;
}
