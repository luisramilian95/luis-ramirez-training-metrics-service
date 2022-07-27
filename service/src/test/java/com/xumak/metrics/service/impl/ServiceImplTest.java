package com.xumak.metrics.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {com.xumak.metrics.service.IService.class})
public class ServiceImplTest {

    @InjectMocks
    ServiceImpl service;

    @DisplayName("Test Hello World!")
    @Test
    void testGet() {
        assertEquals("Hello World!", service.hello());
    }

}
