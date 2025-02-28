package com.mpc.springboot.shared;

import jakarta.transaction.Transactional;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractRepositoryTest {

    protected static final String NO_SETUP = "NoSetup";

    @BeforeEach
    void commonSetUp(TestInfo testInfo) {
        if (hasNoSetupTag(testInfo)) {
            return;
        }
        setUp();
    }

    private static boolean hasNoSetupTag(TestInfo testInfo) {
        return testInfo.getTags()
            .contains(NO_SETUP);
    }

    protected abstract void setUp();
}
