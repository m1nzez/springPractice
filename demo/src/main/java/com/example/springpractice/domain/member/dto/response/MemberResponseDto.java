package com.example.springpractice.domain.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private Long memberId;
    private String email;
    private String nickname;
    private String providerType;
}
