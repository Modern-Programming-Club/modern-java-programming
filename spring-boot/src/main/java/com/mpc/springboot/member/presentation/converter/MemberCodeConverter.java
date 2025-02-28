package com.mpc.springboot.member.presentation.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.mpc.springboot.member.domain.vo.MemberCode;

@Component
public class MemberCodeConverter implements Converter<String, MemberCode> {
    @Override
    public MemberCode convert(String source) {
        return MemberCode.of(source);
    }
}