package com.mpc.springboot.member.application.service;

import org.springframework.stereotype.Service;
import com.mpc.springboot.member.application.dto.MemberResponse;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse getMemberBy(MemberCode memberCode) {
        return MemberResponse.of(memberRepository.findMemberBy(memberCode));
    }
}
