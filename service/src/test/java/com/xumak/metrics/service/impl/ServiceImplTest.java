package com.xumak.metrics.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ServiceImplTest {

    @InjectMocks
    ServiceImpl service;

    @DisplayName("Test Hello World!")
    @Test
    void testGet() {
        assertEquals("Hello World!", service.hello());
    }

}
