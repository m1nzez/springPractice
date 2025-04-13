package com.example.springpractice.domain.article.controller;

import com.example.springpractice.apiPayload.ApiResponse;
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
    public ApiResponse<String> updateArticle(@RequestBody UpdateArticleRequestDTO dto) {
        articleService.updateArticle(dto);

        return ApiResponse.onSuccess("게시글이 수정되었습니다.");
    }

    @DeleteMapping("/article/{articleId}")
    public ApiResponse<String> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);

        return ApiResponse.onSuccess("게시글이 삭제되었습니다.");
    }
}
