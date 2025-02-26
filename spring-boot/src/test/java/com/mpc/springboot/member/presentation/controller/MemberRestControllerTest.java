package com.mpc.springboot.member.presentation.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.mpc.springboot.member.application.service.MemberService;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;
import com.mpc.springboot.member.domain.vo.MemberName;
import com.mpc.springboot.shared.AbstractControllerTest;
import com.mpc.springboot.shared.domain.AuditFields;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberRestController.class)
class MemberRestControllerTest extends AbstractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MemberService memberService;

    @Test
    void getMemberBy() throws Exception {
        // given
        MemberCode code = MemberCode.of("M0000006");
        MemberName name = MemberName.of("foo", "bar");
        Member member = Member.of(code, name);
        given(memberService.getMemberBy(any())).willReturn(member);

        // when & then
        mockMvc.perform(get("/api/v1/members/{code}", code))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code.value").value(code.getValue()))
            .andExpect(jsonPath("$.name.firstName").value(name.getFirstName()))
            .andExpect(jsonPath("$.name.lastName").value(name.getLastName()))
            .andExpect(jsonPath("$.auditFields.createdBy").isEmpty())
            .andExpect(jsonPath("$.auditFields.createdDateTime").isEmpty())
            .andExpect(jsonPath("$.auditFields.updatedBy").isEmpty())
            .andExpect(jsonPath("$.auditFields.updatedDateTime").isEmpty());

    }

    @Test
    void createMember() {
    }
}