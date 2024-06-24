package com.react.analytics.spring_react.services;
import com.react.analytics.spring_react.dto.AnalyticsDto;
import com.react.analytics.spring_react.entities.Analytics;
import com.react.analytics.spring_react.exceptions.exceptions.AnalyticsNotFoundException;
import com.react.analytics.spring_react.repositories.AnalyticsRepo;
import com.react.analytics.spring_react.servises.implementation.AnalyticsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class AnalyticsServiceImplTest {

    @Mock
    private AnalyticsRepo analyticsRepo;

    @InjectMocks
    private AnalyticsServiceImpl analyticsService;

    @BeforeEach
    void setUp() {
        analyticsService = new AnalyticsServiceImpl(analyticsRepo);
    }

    @Test
    void testAnalyticsAreFound() {

        Analytics analytics = new Analytics();
        List<Analytics> analyticsList = List.of(analytics);
        when(analyticsRepo.findAll()).thenReturn(analyticsList);

        AnalyticsDto expectedDto = AnalyticsDto.mapToAnalyticsDto(analytics);


        List<AnalyticsDto> result = analyticsService.getAnalytics();


        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(expectedDto, result.get(0));
        verify(analyticsRepo, times(1)).findAll();
    }

    @Test
    void testAnalyticsNotFound() {

        when(analyticsRepo.findAll()).thenReturn(Collections.emptyList());

        AnalyticsNotFoundException exception = assertThrows(AnalyticsNotFoundException.class, () -> {
            analyticsService.getAnalytics();
        });

        assertEquals("Analytics were not found", exception.getMessage());
        verify(analyticsRepo, times(1)).findAll();
    }
}