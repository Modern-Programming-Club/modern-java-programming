package com.mpc.springboot.member.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mpc.springboot.member.application.dto.CreateMemberRequest;
import com.mpc.springboot.member.application.dto.MemberResponse;
import com.mpc.springboot.member.application.service.MemberService;
import com.mpc.springboot.member.domain.entity.Member;
import com.mpc.springboot.member.domain.vo.MemberCode;
import lombok.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberRestController {

    private final MemberService memberService;

    @GetMapping("/{code}")
    public ResponseEntity<MemberResponse> getMemberBy(@PathVariable MemberCode code) {
        return ResponseEntity.ok(memberService.getMemberBy(code));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@RequestBody CreateMemberRequest request) {
        return ResponseEntity.ok(memberService.createMember(request));
    }
}
