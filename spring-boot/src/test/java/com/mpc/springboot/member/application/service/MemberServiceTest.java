package com.mpc.springboot.member.application.service;

import java.util.Optional;

import com.mpc.springboot.member.application.dto.MemberResponse;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import com.mpc.springboot.shared.AbstractServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class MemberServiceTest extends AbstractServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @DisplayName("멤버 조회 테스트")
    @Test
    void getMemberBy() {
        // given
        MemberCode code = MemberCode.of("M0000016");
        MemberName name = MemberName.of("Jinwoo", "Kim");
        Member member = Member.of(code, name);
        Optional<Member> memberOptional = Optional.of(member);

        given(memberRepository.findMemberBy(any())).willReturn(memberOptional);

        // when
        MemberResponse memberResponse = memberService.getMemberBy(code);

        // then
        assertNotNull(memberResponse);
        assertEquals(code, memberResponse.getCode());
        assertEquals(name, memberResponse.getName());
    }

    @Test
    void createMember() {
    }
}