package com.mpc.springboot.member.domain.repository;

import java.util.Optional;

import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;

public interface MemberRepository {

     Optional<Member> findMemberBy(MemberCode code);

     Member save(Member member);
}
