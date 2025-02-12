package com.mpc.springboot.member.domain.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberName {
    private final String firstName;
    private final String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
