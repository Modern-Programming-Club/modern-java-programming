package com.mpc.springboot.member.presentation.controller;

import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import com.mpc.springboot.shared.AbstractIntegrationTest;
import com.mpc.springboot.shared.type.TestTag;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class MemberRestControllerIntegrationTest extends AbstractIntegrationTest {

    private Member savedMember;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    protected void setUp() {
        // given
        MemberCode code = MemberCode.of("T0000001");
        MemberName name = MemberName.of("Alice", "Smith");
        savedMember = memberRepository.save(Member.of(code, name));
    }

    @DisplayName("멤버 생성 API 통합 테스트")
    @Tag(TestTag.NO_SETUP)
    @Test
    void createMember() throws Exception {
        // given
        MemberCode code = MemberCode.of("T0000001");
        MemberName name = MemberName.of("Alice", "Smith");
        Member member = Member.of(code, name);

        // when & then
        mockMvc.perform(post("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(member)))
                .andExpect(status().isOk());
    }



    @DisplayName("멤버 조회 API 통합 테스트")
    @Test
    void getMemberBy() throws Exception {
        // given
        MemberCode code = savedMember.getCode();
        MemberName name = savedMember.getName();

        // when & then
        mockMvc.perform(get("/api/v1/members/{code}", code.getValue()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code.value").value(code.getValue()))
            .andExpect(jsonPath("$.name.firstName").value(name.getFirstName()))
            .andExpect(jsonPath("$.name.lastName").value(name.getLastName()))
            .andExpect(jsonPath("$.name.fullName").value(name.getFullName()));
    }
}
