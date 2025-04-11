package com.example.springpractice.domain.member.repository;

import com.example.springpractice.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByProviderType(String providerType);
}
