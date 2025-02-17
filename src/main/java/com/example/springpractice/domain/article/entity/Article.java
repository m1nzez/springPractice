package com.example.springpractice.domain.article.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Member member;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Category> categoryList;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Comment> commentList;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Like> like
}
