package com.example.springpractice.domain.article.controller;

import com.example.springpractice.domain.article.dto.request.PostArticleRequestDTO;
import com.example.springpractice.domain.article.dto.response.ArticleResponseDTO;
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
    public ArticleResponseDTO postArticle(@RequestBody PostArticleRequestDTO dto) {
        Article article = articleService.createArticle(dto);

        return ArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content((article.getContent()))
                .build();
    }

    @GetMapping("/article/{articleId}")
    public ArticleResponseDTO getOneArticle(@PathVariable Long articleId) {
        Article article = articleService.readArticleById(articleId);

        return ArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content((article.getContent()))
                .build();
    }

    @GetMapping("/article")
    public List<ArticleResponseDTO> getArticle() {

        return articleService.readAllArticles().stream()
                .map(article -> ArticleResponseDTO.builder()
                        .id(article.getId())
                        .title(article.getTitle())
                        .content(article.getContent())
                        .build())
                .toList();

    }

    @PutMapping("/article")
    public ArticleResponseDTO.UpdateArticleResponseDTO updateArticle(@RequestBody UpdateArticleRequestDTO dto) {
        Article article = articleService.updateArticle(dto);

        return ArticleResponseDTO.UpdateArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }

    @DeleteMapping("/article/{articleId}")
    public void deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
    }
}
