package io.github.mooy1.simpleutils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class TestSimpleUtils {

    @Test
    void classLoads() {
        assertDoesNotThrow(() -> Class.forName("io.github.mooy1.simpleutils.SimpleUtils"));
    }

}
