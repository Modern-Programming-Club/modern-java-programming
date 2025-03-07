package com.mpc.springboot.member.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.*;

@Getter
@NoArgsConstructor
@Embeddable
public class MemberName {

    private String firstName;
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private MemberName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static MemberName of(String firstName, String lastName) {
        return new MemberName(firstName, lastName);
    }
}
