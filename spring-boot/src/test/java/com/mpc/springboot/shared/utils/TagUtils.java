package com.mpc.springboot.shared.utils;

import com.mpc.springboot.shared.type.TestTag;
import org.junit.jupiter.api.TestInfo;

public class TagUtils {

    private TagUtils() {
        // Utility class
    }

    public static boolean hasNoSetupTag(TestInfo testInfo) {
        return testInfo.getTags()
            .contains(TestTag.NO_SETUP);
    }
}
