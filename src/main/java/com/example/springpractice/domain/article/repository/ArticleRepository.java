package com.example.springpractice.domain.article.repository;

import com.example.springpractice.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {


}
