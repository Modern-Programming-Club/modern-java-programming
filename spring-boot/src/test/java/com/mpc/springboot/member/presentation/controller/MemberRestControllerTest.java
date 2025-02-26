package com.mpc.springboot.member.presentation.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import com.mpc.springboot.member.application.dto.MemberResponse;
import com.mpc.springboot.member.application.service.MemberService;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.repository.MemberRepository;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import com.mpc.springboot.shared.AbstractControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberRestController.class)
class MemberRestControllerTest extends AbstractControllerTest {

    @MockitoBean
    private MemberService memberService;

    /**
     * @see MemberRestController#getMemberBy(MemberCode)
     */
    @DisplayName("회원 조회: 회원 코드로 조회")
    @Test
    void getMemberBy() throws Exception {
        // given
        MemberCode code = MemberCode.of("M0000003");
        MemberName name = MemberName.of("John", "Doe");
        Member member = Member.of(code, name);
        MemberResponse memberResponse = MemberResponse.from(member);
        given(memberService.getMemberBy(any())).willReturn(memberResponse);

        // when & then
        mockMvc.perform(get("/api/v1/members/{code}", code.getValue()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code.value").value(code.getValue()))
            .andExpect(jsonPath("$.name.firstName").value(name.getFirstName()))
            .andExpect(jsonPath("$.name.lastName").value(name.getLastName()))
            .andExpect(jsonPath("$.name.fullName").value(name.getFullName()));

    }

    @Test
    void createMember() {
    }
}