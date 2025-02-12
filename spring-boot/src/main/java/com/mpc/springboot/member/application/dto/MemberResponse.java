package com.mpc.springboot.member.application.dto;

import com.mpc.springboot.member.domain.dto.MemberView;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberResponse {
    private final MemberCode memberCode;
    private final MemberName memberName;

    public static MemberResponse of(MemberView memberView) {
        return new MemberResponse(memberView.getMemberCode(), memberView.getMemberName());
    }
}
