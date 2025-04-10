package com.example.springpractice.domain.category.dto.response;


import com.example.springpractice.domain.category.entity.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCategoryResponseDto {
    private Long id;
    private Category category;
    private String title;
    private String content;
}
