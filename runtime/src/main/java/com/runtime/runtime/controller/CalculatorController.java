package com.runtime.runtime.controller;

import com.runtime.runtime.model.*;
import com.runtime.runtime.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculatePace")
    public Pace calculatePace(@RequestBody PaceRequest paceRequest) {
        return calculatorService.calculatePace(paceRequest);
    }

    @PostMapping("/calculateDistance")
    public Distance calculateDistance(@RequestBody DistanceRequest distanceRequest) {
        return calculatorService.calculateDistance(distanceRequest);
    }

    @PostMapping("/calculateTotalTime")
    public TotalTime calculateTotalTime(@RequestBody TotalTimeRequest totalTimeRequest) {
        return calculatorService.calculateTotalTime(totalTimeRequest);
    }
}
