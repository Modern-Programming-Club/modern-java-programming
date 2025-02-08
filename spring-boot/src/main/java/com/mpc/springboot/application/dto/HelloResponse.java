package com.mpc.springboot.application.dto;

import com.mpc.springboot.infrastructure.dto.HelloView;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloResponse {
    private final String lang;
    private final String value;

    // 팩토리 메소드 패턴
    public static HelloResponse of(String lang, String value) {
        return new HelloResponse(lang, value);
    }

    public static HelloResponse ofKorean(String value) {
        return new HelloResponse("kor", value);
    }

    public static HelloResponse ofEnglish(String value) {
        return new HelloResponse("eng", value);
    }

    public static HelloResponse of(HelloView view) {
        return new HelloResponse(view.getLang(), view.getValue());
    }
}
