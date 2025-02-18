package com.example.springpractice.domain.article.dto.request;

import lombok.Getter;

@Getter
public class UpdateArticleRequestDTO {

    private Long id;
    private String title;
    private String content;
}
