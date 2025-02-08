package com.mpc.springboot.infrastructure.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloView {
    private final String lang;
    private final String value;

    public static HelloView of(String lang, String value) {
        return new HelloView(lang, value);
    }
}
