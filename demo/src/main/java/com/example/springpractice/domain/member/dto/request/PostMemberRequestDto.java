package com.example.springpractice.domain.member.dto.request;

import lombok.Getter;

@Getter
public class PostMemberRequestDto {
    private String email;
    private String nickname;
    private String providerId;
    private String providerType;
}
