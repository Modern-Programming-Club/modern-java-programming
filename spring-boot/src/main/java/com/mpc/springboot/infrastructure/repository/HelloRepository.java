package com.mpc.springboot.infrastructure.repository;

import org.springframework.stereotype.Repository;
import com.mpc.springboot.infrastructure.dto.HelloView;

@Repository
public class HelloRepository {

    public HelloView hello(String lang) {
        return HelloView.of(lang, "hello");
    }
}
