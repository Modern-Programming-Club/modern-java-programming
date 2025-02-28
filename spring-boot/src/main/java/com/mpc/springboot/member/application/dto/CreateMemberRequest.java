package com.mpc.springboot.member.application.dto;

import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import lombok.*;

@Getter
@NoArgsConstructor
public class CreateMemberRequest {
    private MemberCode code;
    private MemberName name;

    public CreateMemberRequest(MemberCode code, MemberName name) {
        this.code = code;
        this.name = name;
    }

    public Member toEntity() {
        return Member.of(code, name);
    }
}
