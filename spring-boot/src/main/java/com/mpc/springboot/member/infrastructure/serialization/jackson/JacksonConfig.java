package com.mpc.springboot.member.infrastructure.serialization.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        return builder -> {
            SimpleModule module = new SimpleModule();
            module.addSerializer(MemberCode.class, new MemberCodeSerializer());
            builder.modules(module);
        };
    }
}
