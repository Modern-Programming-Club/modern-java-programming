package com.mpc.springboot.member.domain.exception;

public class MemberNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Member not found";

    public MemberNotFoundException() {
        super(MESSAGE);
    }

    public MemberNotFoundException(String message) {
        super(message);
    }
}
