package com.example.springpractice.domain.article.controller;

import com.example.springpractice.domain.article.dto.request.PostArticleRequestDTO;
import com.example.springpractice.domain.article.dto.response.PostArticleResponseDTO;
import com.example.springpractice.domain.article.dto.request.UpdateArticleRequestDTO;
import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public PostArticleResponseDTO postArticleDto(@RequestBody PostArticleRequestDTO dto) {
        Article article = articleService.createArticle(dto);

        return PostArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content((article.getContent()))
                .build();
    }

    @GetMapping("/article/{articleId}")
    public PostArticleResponseDTO getOneArticleDto(@PathVariable Long articleId) {
        Article article = articleService.readArticleById(articleId);

        return PostArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content((article.getContent()))
                .build();
    }

    @GetMapping("/article")
    public List<PostArticleResponseDTO> getArticleDto() {

        return articleService.readAllArticles().stream()
                .map(article -> PostArticleResponseDTO.builder()
                        .id(article.getId())
                        .title(article.getTitle())
                        .content(article.getContent())
                        .build())
                .toList();

    }

    @PutMapping("/article")
    public PostArticleResponseDTO.UpdateArticleResponseDTO updateArticleDto(@RequestBody UpdateArticleRequestDTO dto) {
        Article article = articleService.updateArticle(dto);

        return PostArticleResponseDTO.UpdateArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }

    @DeleteMapping("/article/{articleId}")
    public void deleteArticleDto(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
    }
}
