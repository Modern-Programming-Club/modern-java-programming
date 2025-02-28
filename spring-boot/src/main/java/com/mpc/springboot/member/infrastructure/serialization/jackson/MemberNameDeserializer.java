package com.mpc.springboot.member.infrastructure.serialization.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.mpc.springboot.member.domain.vo.MemberName;

import java.io.IOException;

public class MemberNameDeserializer extends JsonDeserializer<MemberName> {
    @Override
    public MemberName deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        // JSON의 루트에서 firstName, lastName 가져오기
        String firstName = node.has("firstName") ? node.get("firstName").asText() : "";
        String lastName = node.has("lastName") ? node.get("lastName").asText() : "";

        return MemberName.of(firstName, lastName);
    }
}
