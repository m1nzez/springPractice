package com.example.springpractice.domain.comment.repository;


import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findCommentsByArticle(Long articleId);
}


