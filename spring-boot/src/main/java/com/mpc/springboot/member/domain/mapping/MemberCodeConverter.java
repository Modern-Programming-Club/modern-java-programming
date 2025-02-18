package com.mpc.springboot.member.domain.mapping;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

import com.mpc.springboot.member.domain.vo.MemberCode;

@Converter
public class MemberCodeConverter implements AttributeConverter<MemberCode, String> {

    @Override
    public String convertToDatabaseColumn(MemberCode attribute) {
        if (attribute == null) {
            return "";
        }
        return attribute.getValue();
    }

    @Override
    public MemberCode convertToEntityAttribute(String dbData) {
        String value = Objects.requireNonNullElse(dbData, "");
        return new MemberCode(value);
    }
}
