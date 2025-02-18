package com.mpc.springboot.member.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByCode(MemberCode code);
}
