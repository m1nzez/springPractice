package com.example.springpractice.domain.comment.entity;

import com.example.springpractice.domain.article.entity.Article;
import com.example.springpractice.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate      // 엔티티가 처음 저장도리때 시간 자동 설정
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "content")
    private String content;

    @Column(name = "is_like")
    private Boolean isLike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void update(String content) {
        this.content = content;
    }
}


