package com.example.springpractice.domain.article.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class ArticleResponseDTO {

    private Long id;
    private String title;
    private String content;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateArticleResponseDTO {

        private Long id;
        private String title;
        private String content;
    }
}
