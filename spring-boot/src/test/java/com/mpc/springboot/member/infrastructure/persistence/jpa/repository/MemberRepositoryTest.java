package com.mpc.springboot.member.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import com.mpc.springboot.shared.AbstractRepositoryTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private Member savedMember;

    @Override
    protected void setUp() {
        // given
        MemberCode code = MemberCode.of("T0000001");
        MemberName name = MemberName.of("Alice", "Smith");
        savedMember = memberRepository.save(Member.of(code, name));
    }

    @DisplayName("멤버 저장 테스트")
    @Tag(NO_SETUP)
    @Test
    void save() {
        // given
        MemberCode code = MemberCode.of("T0000001");
        MemberName name = MemberName.of("Alice", "Smith");
        Member member = Member.of(code, name);

        // when
        Member saved = memberRepository.save(member);

        // then
        assertNotNull(saved);
        assertEquals(code, saved.getCode());
        assertEquals(name, saved.getName());
    }

    @Test
    void findMemberBy() {
        // given
        MemberCode code = savedMember.getCode();

        // when
        Optional<Member> result = memberRepository.findMemberBy(code);

        // then
        assertTrue(result.isPresent());
        assertEquals(savedMember.getCode(), result.get().getCode());
        assertEquals(savedMember.getName(), result.get().getName());
    }


}