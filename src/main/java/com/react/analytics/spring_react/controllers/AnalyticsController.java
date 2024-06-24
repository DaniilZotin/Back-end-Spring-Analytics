package com.react.analytics.spring_react.controllers;

import com.react.analytics.spring_react.dto.AnalyticsDto;
import com.react.analytics.spring_react.exceptions.exceptions.AnalyticsNotFoundException;
import com.react.analytics.spring_react.servises.AnalyticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class AnalyticsController {

    private final AnalyticsService analyticsService;


    @GetMapping("getDataAnalytics")
    public ResponseEntity<?> getDataAnalytics() {
        try {
            List<AnalyticsDto> analytics = analyticsService.getAnalytics();
            return new ResponseEntity<>(analytics, HttpStatus.OK);
        } catch (AnalyticsNotFoundException e) {
            log.error("Analytics not found", e);
            return new ResponseEntity<>("Analytics not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("System error", e);
            return new ResponseEntity<>("System error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This endpoint created for testing system in different situation
     * check video
     * **/
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, String>> deleteAnalytics(@PathVariable("id") Long id) {

        analyticsService.deleteAnalyticsById(id);

        Map<String, String> map =  new TreeMap<>();
        map.put("result:", "you have deleted analytics with id: " + id);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    /**
     * This endpoint created for testing system in different situation
     * check video
     * **/
    @PostMapping("createDataForTestSystemInVideo")
    public String createData() {
        analyticsService.createAnalyticsData();
        return "Check logs";
    }


}
