package com.example.springpractice.domain.category.dto.response;


import com.example.springpractice.domain.category.entity.CategoryType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCategoryResponseDto {
    private Long id;
    private CategoryType categoryType;
    private String title;
    private String content;
}
