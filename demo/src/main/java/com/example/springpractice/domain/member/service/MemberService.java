package com.example.springpractice.domain.member.service;

import com.example.springpractice.domain.member.dto.request.PostMemberRequestDto;
import com.example.springpractice.domain.member.dto.request.UpdateMemberNicknameRequestDto;
import com.example.springpractice.domain.member.entity.Member;
import com.example.springpractice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private static MemberRepository memberRepository;

    public Member createMember(PostMemberRequestDto dto) {
        Member member = Member.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .providerId(dto.getProviderId())
                .providerType(dto.getProviderType())
                .build();

        return memberRepository.save(member);
    }

    public List<Member> getMember() {
        return memberRepository.findAll();
    }

    public List<Member> getMemberByProviderType(String providerType) {
        return memberRepository.findByProviderType(providerType);
    }

    public Member updateMemberNickname(UpdateMemberNicknameRequestDto dto) {
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
