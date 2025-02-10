package com.example.springpractice.domain.article.entity;

import com.example.springpractice.domain.category.entity.Category;
import com.example.springpractice.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categoryList;
}
