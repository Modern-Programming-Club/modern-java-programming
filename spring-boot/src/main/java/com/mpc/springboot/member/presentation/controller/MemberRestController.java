package com.mpc.springboot.member.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Member> getMemberBy(@PathVariable MemberCode code) {
        return ResponseEntity.ok(memberService.getMemberBy(code));
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.createMember(member));
    }
}
