package com.react.analytics.spring_react.servises.implementation;

import com.react.analytics.spring_react.dto.AnalyticsDto;
import com.react.analytics.spring_react.entities.Analytics;
import com.react.analytics.spring_react.exceptions.exceptions.AnalyticsNotFoundException;
import com.react.analytics.spring_react.repositories.AnalyticsRepo;
import com.react.analytics.spring_react.servises.AnalyticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final AnalyticsRepo analyticsRepo;

    @Override
    public List<AnalyticsDto> getAnalytics() {
        List<AnalyticsDto> analytics = analyticsRepo.findAll().stream().map(AnalyticsDto::mapToAnalyticsDto).collect(Collectors.toList());

        if (analytics.isEmpty()) {

            throw new AnalyticsNotFoundException("Analytics were not found");
        }

        return analytics;
    }


    /**
     * Functions below were created to show you how program works with exceptions, and logic mistakes
     * **/

    @Override
    public void deleteAnalyticsById(Long id) {

        Optional<Analytics> analyticsToDelete = analyticsRepo.findById(id);

        if(analyticsToDelete.isEmpty()){

            throw new AnalyticsNotFoundException("Analytics with id + " + id + " not found");

        }

        analyticsRepo.delete(analyticsToDelete.get());

    }

    @Override
    public void createAnalyticsData() {

        Analytics analyticsData1 = new Analytics(1L,
                "Pop app into movie sites",2280,60000,3.80,1.80,
                65.00,240.00,28.00,LocalTime.parse("00:03:12"));
        Analytics analyticsData2 = new Analytics(2L,
                "New tech in IT", 2800, 70000, 4.00, 2.00,
                60.00, 280.00, 30.00 ,LocalTime.parse("00:03:30"));
        Analytics analyticsData3 = new Analytics(2L,
                "Job online", 3500, 100000, 3.50, 1.75,
                55.00, 350.00, 25.00,LocalTime.parse("00:04:00"));
        Analytics analyticsData4 = new Analytics(2L,
                "Luxuary cars HD", 1440, 45000, 3.20, 1.20,
                45.00, 190.00, 32.00,LocalTime.parse("00:02:48"));

        if(!analyticsRepo.existsById(1L)){
            analyticsRepo.save(analyticsData1);
            analyticsRepo.save(analyticsData2);
            analyticsRepo.save(analyticsData3);
            analyticsRepo.save(analyticsData4);
        } else {
            System.out.println("delete all info, now you cannot do this");
        }




    }


}
