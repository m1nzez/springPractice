package com.example.springpractice.domain.article.service;

import com.example.springpractice.domain.article.dto.PostArticleRequestDTO;
import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article createArticle(PostArticleRequestDTO dto) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();

        return articleRepository.save(article);
    }

    public Article readArticleById(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow();
    }

    public List<Article> readAllArticles() {
        return articleRepository.findAll();
    }
}
