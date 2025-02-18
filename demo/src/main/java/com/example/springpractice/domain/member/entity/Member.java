package com.example.springpractice.domain.member.entity;

import com.example.springpractice.domain.comment.entity.Comment;
import com.example.springpractice.domain.like.entity.LikeMember;
import com.example.springpractice.domain.report.entity.Report;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "email")
    private String email;

    @Column(name = "provider")
    private String provider;

    @Column(name = "nickname")
    private String nickname;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Article> articleList;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Report> senderList;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Report> receiverList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LikeMember> likeList;

}
