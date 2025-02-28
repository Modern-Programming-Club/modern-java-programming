package com.mpc.springboot.member.domain.vo;

import lombok.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCode {
    private final String value;

    public static MemberCode of(String value) {
        return new MemberCode(value);
    }
}
