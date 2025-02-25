package com.mpc.springboot.member.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByCode(MemberCode code);
}
