package com.react.analytics.spring_react.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.react.analytics.spring_react.servises.implementation.AnalyticsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AnalyticsControllerTest {


    @Mock
    private AnalyticsServiceImpl analyticsService;

    @InjectMocks
    private AnalyticsController analyticsController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(analyticsController).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void getAnalyticsTestWasOk() throws  Exception{
        mockMvc.perform(get("/api/analytics/getDataAnalytics")).andExpect(status().isOk());
    }



}
