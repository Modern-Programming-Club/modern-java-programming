package com.mpc.springboot.member.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Optional<Member> findMemberBy(MemberCode code) {
        return memberJpaRepository.findByCode(code);
    }

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }
}
