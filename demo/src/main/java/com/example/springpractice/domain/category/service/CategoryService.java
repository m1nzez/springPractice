package com.example.springpractice.domain.category.service;

import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ArticleRepository articleRepository;

    // ArticleRepository에서 반환하는 타입에 맞게 타입을 리턴해야함..
    public List<Article> getArticlesByCategory(String categoryType) {
        return articleRepository.findAllByCategoryType(categoryType);
    }
}
