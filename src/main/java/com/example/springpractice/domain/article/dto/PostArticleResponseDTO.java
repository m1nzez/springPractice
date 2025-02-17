package com.example.springpractice.domain.article.dto;

import lombok.Builder;

@Builder
public class PostArticleResponseDTO {

    private Long id;
    private String title;
    private String content;
}
