package com.react.analytics.spring_react.servises;

import com.react.analytics.spring_react.dto.AnalyticsDto;

import java.util.List;

public interface AnalyticsService {
    List<AnalyticsDto> getAnalytics();

    void deleteAnalyticsById(Long id);

    void createAnalyticsData();
}
