package com.mpc.springboot.member.domain.repository;

import org.springframework.stereotype.Repository;
import com.mpc.springboot.member.domain.dto.MemberView;
import com.mpc.springboot.member.domain.vo.MemberCode;

public interface MemberRepository {

     MemberView findMemberBy(MemberCode memberCode);
}
