package com.example.springpractice.domain.category.entity;

import com.example.springpractice.domain.article.entity.Article;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_type")
    private CategoryType categoryType;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Article> articles;
}
