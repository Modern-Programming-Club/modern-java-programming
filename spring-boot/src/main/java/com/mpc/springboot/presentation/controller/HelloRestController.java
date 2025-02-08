package com.mpc.springboot.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mpc.springboot.application.dto.HelloResponse;
import com.mpc.springboot.application.service.HelloService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/test")
public class HelloRestController {

    private final HelloService helloService;

    @GetMapping
    public ResponseEntity<HelloResponse> hello(@RequestParam String lang) {
        return ResponseEntity.ok(helloService.hello(lang));
    }
}
