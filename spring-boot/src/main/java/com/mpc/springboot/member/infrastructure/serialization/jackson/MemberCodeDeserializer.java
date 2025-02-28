package com.mpc.springboot.member.infrastructure.serialization.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.mpc.springboot.member.domain.vo.MemberCode;

public class MemberCodeDeserializer extends JsonDeserializer<MemberCode> {
    @Override
    public MemberCode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return MemberCode.of(p.getText());
    }
}