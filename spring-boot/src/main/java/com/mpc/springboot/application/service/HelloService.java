package com.mpc.springboot.application.service;

import org.springframework.stereotype.Service;
import com.mpc.springboot.application.dto.HelloResponse;
import com.mpc.springboot.infrastructure.repository.HelloRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HelloService {

    private final HelloRepository helloRepository;

    public HelloResponse hello(String lang) {
        return HelloResponse.of(helloRepository.hello(lang));
    }
}
