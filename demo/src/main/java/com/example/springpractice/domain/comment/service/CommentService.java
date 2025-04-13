package com.example.springpractice.domain.comment.service;

import com.example.springpractice.domain.article.dto.request.PostArticleRequestDTO;
import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.article.repository.ArticleRepository;
import com.example.springpractice.domain.comment.dto.request.PostCommentRequestDto;
import com.example.springpractice.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.springpractice.domain.comment.entity.Comment;
import com.example.springpractice.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public Comment createComment(PostCommentRequestDto dto) {
        Article articleId = articleRepository.findById(dto.getArticleId()).orElseThrow();

        Comment comment = Comment.builder()
                .content(dto.getContent())
                .article(articleId)
                .build();
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByArticle(Long articleId) {
        return commentRepository.findCommentsByArticle(articleId);
    }

    public void updateComment(UpdateCommentRequestDto dto) {
        Comment comment = commentRepository.findById(dto.getCommentId()).orElseThrow();
        comment.update(dto.getContent());
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
