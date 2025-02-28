package com.mpc.springboot.member.infrastructure.serialization.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mpc.springboot.member.domain.vo.MemberCode;

public class MemberCodeSerializer extends JsonSerializer<MemberCode> {
    @Override
    public void serialize(MemberCode value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getValue());
    }
}