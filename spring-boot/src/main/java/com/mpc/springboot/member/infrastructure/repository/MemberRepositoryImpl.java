package com.mpc.springboot.member.infrastructure.repository;

import org.springframework.stereotype.Repository;
import com.mpc.springboot.member.domain.dto.MemberView;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    @Override
    public MemberView findMemberBy(MemberCode memberCode) {
        return new MemberView(memberCode, new MemberName("준헌", "안"));
    }
}
