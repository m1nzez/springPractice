package com.example.springpractice.domain.category.controller;

import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.category.dto.response.GetCategoryResponseDto;
import com.example.springpractice.domain.category.entity.Category;
import com.example.springpractice.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 별 조회
    @GetMapping("/articles/{category}")
    public List<GetCategoryResponseDto> getArticlesByCategory(@PathVariable String categoryType) {
        List<Article> articles = categoryService.getArticlesByCategory(categoryType);

        return articles.stream()
                .map(article -> GetCategoryResponseDto.builder()
                        .category(article.getCategory())
                        .id(article.getId())
                        .title(article.getTitle())
                        .content(article.getContent())
                        .build())
                .toList();
    }

}
