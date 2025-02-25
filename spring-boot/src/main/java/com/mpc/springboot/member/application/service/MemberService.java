package com.mpc.springboot.member.application.service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.exception.MemberNotFoundException;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMemberBy(MemberCode code) {
        return memberRepository.findMemberBy(code)
                .orElseThrow(MemberNotFoundException::new);
    }

    @Transactional
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }
}
