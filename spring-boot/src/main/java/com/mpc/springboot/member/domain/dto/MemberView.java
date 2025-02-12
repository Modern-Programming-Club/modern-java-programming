package com.mpc.springboot.member.domain.dto;

import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberView {
    private final MemberCode memberCode;
    private final MemberName memberName;

    public static MemberView of(MemberCode memberCode, MemberName memberName) {
        return new MemberView(memberCode, memberName);
    }
}
