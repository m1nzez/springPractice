package com.example.springpractice.domain.article.repository;

import com.example.springpractice.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByCategoryType(String type);

    List<Article> findAllLikedArticles(Boolean isLiked);
}
