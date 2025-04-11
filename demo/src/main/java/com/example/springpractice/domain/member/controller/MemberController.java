package com.example.springpractice.domain.member.controller;

import com.example.springpractice.domain.member.dto.request.PostMemberRequestDto;
import com.example.springpractice.domain.member.dto.request.UpdateMemberNicknameRequestDto;
import com.example.springpractice.domain.member.dto.response.MemberResponseDto;
import com.example.springpractice.domain.member.entity.Member;
import com.example.springpractice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private static MemberService memberService;

    @PostMapping("/member/")
    public MemberResponseDto createMemberResponse(@RequestBody PostMemberRequestDto dto) {
        Member member = memberService.createMember(dto);

        return MemberResponseDto.builder()
                .memberId(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .providerType(member.getProviderType())
                .build();
    }

    @GetMapping("/member/")
    public List<MemberResponseDto> getMemberResponse() {
        return memberService.getMember().stream()
                .map(member -> MemberResponseDto.builder()
                        .memberId(member.getId())
                        .email(member.getEmail())
                        .nickname(member.getNickname())
                        .providerType(member.getProviderType())
                        .build())
                .toList();
    }

    @GetMapping("/member/{providerType}")
    public List<MemberResponseDto> getMemberByProviderTypeResponse(@PathVariable String providerType) {
        return memberService.getMemberByProviderType(providerType).stream()
                .map(member -> MemberResponseDto.builder()
                        .memberId(member.getId())
                        .email(member.getEmail())
                        .nickname(member.getNickname())
                        .providerType(member.getProviderType())
                        .build())
                .toList();
    }


//    @PatchMapping("/member/")
//    public MemberResponseDto updateMemberNicknameResponse(@RequestBody UpdateMemberNicknameRequestDto dto) {
//
//    }

    @DeleteMapping("/member/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
