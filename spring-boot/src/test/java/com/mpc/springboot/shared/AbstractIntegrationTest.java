package com.mpc.springboot.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpc.springboot.Application;
import com.mpc.springboot.shared.utils.TagUtils;
import org.junit.jupiter.api.*;


@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;


    @BeforeEach
    void commonSetUp(TestInfo testInfo) {
        if (TagUtils.hasNoSetupTag(testInfo)) {
            return;
        }
        setUp();
    }

    protected abstract void setUp();
}
