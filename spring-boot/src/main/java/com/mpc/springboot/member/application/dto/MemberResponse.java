package com.mpc.springboot.member.application.dto;

import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponse {
    private final MemberCode code;
    private final MemberName name;

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getCode(), member.getName());
    }
}
