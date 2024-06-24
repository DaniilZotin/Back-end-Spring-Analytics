package com.react.analytics.spring_react.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "\"analytics\"")
@AllArgsConstructor
@NoArgsConstructor
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analytics_id")
    Long id;

    @Column(name = "name", unique = true)
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Column(name = "click")
    @NotNull(message = "Clicks cannot be empty")
    private Integer click;

    @Column(name = "impression")
    @NotNull(message = "Impression cannot be empty")
    private Integer impression;

    @Column(name = "CTR")
    @NotNull(message = "Click-Through Rate cannot be empty")
    private Double CTR;

    @Column(name = "CPC")
    private Double CPC;

    @Column(name = "CPA")
    private Double CPA;

    @Column(name = "conversion")
    private Double conversion;

    @Column(name = "bounce_rate")
    private Double bounceRate;

    @Column(name = "avg_time_on_site")
    @NotNull(message = "avgTimeOnSite cannot be empty")
    private LocalTime avgTimeOnSite;

}
