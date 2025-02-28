package com.mpc.springboot.member.application.dto;

import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateMemberRequest {
    private final MemberCode code;
    private final MemberName name;

    public Member toEntity() {
        return Member.of(code, name);
    }
}
