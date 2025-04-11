package com.example.springpractice.domain.comment.controller;

import com.example.springpractice.domain.article.dto.request.UpdateArticleRequestDTO;
import com.example.springpractice.domain.article.dto.response.ArticleResponseDTO;
import com.example.springpractice.domain.comment.dto.request.PostCommentRequestDto;
import com.example.springpractice.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.springpractice.domain.comment.dto.response.CommentResponseDto;
import com.example.springpractice.domain.comment.entity.Comment;
import com.example.springpractice.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/article/comment/")
    public CommentResponseDto postCommentResponse(@RequestBody PostCommentRequestDto dto) {
        Comment comment = commentService.createComment(dto);

        return CommentResponseDto.builder()
                .articleId(comment.getArticle().getId())
                .commentId(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .isLiked(comment.getIsLike())
                .build();

    }

    @GetMapping("/article/comment/{articleId}")
    public List<CommentResponseDto> getCommentResponse(@PathVariable Long articleId) {

        return commentService.getCommentsByArticle(articleId).stream()
                .map(comment -> CommentResponseDto.builder()
                        .articleId(comment.getArticle().getId())
                        .commentId(comment.getId())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .isLiked(comment.getIsLike())
                        .build())
                .toList();
    }

    @PutMapping("/article/comment/")
    public CommentResponseDto updateCommentResponse(@RequestBody UpdateCommentRequestDto dto) {
        Comment comment = commentService.updateComment(dto);

        return CommentResponseDto.builder()
                .articleId(comment.getArticle().getId())
                .commentId(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .isLiked(comment.getIsLike())
                .build();
    }


    @DeleteMapping("/article/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
