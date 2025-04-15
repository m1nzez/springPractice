package com.example.springpractice.domain.article.converter;

import com.example.springpractice.domain.article.dto.response.ArticleResponseDTO;
import com.example.springpractice.domain.article.entity.Article;

public class ArticleConverter {

    public static ArticleResponseDTO toArticleDTO(Article article) {
        return ArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }
}

