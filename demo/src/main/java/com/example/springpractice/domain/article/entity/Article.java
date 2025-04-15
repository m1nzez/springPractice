package com.example.springpractice.domain.article.entity;

import com.example.springpractice.domain.category.entity.Category;
import com.example.springpractice.domain.comment.entity.Comment;
import com.example.springpractice.domain.like.entity.LikeMember;
import com.example.springpractice.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LikeMember> like;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
