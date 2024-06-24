package com.react.analytics.spring_react.repositories;

import com.react.analytics.spring_react.entities.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticsRepo extends JpaRepository<Analytics, Long>  {

}
