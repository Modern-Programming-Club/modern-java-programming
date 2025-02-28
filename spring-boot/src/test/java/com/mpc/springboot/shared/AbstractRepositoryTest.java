package com.mpc.springboot.shared;

import jakarta.transaction.Transactional;

import org.springframework.boot.test.context.SpringBootTest;
import com.mpc.springboot.shared.utils.TagUtils;
import org.junit.jupiter.api.*;

@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractRepositoryTest {

    @BeforeEach
    void commonSetUp(TestInfo testInfo) {
        if (TagUtils.hasNoSetupTag(testInfo)) {
            return;
        }
        setUp();
    }

    protected abstract void setUp();
}
