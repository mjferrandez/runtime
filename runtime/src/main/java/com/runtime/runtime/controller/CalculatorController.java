package com.runtime.runtime.controller;

import com.runtime.runtime.dto.*;
import com.runtime.runtime.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    private CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculatePace")
    public PaceDTO calculatePace(@RequestBody @Valid PaceRequestDTO paceRequestDTO) {
        return calculatorService.calculatePace(paceRequestDTO);
    }

    @PostMapping("/calculateDistance")
    public DistanceDTO calculateDistance(@RequestBody @Valid DistanceRequestDTO distanceRequestDTO) {
        return calculatorService.calculateDistance(distanceRequestDTO);
    }

    @PostMapping("/calculateTotalTime")
    public TotalTimeDTO calculateTotalTime(@RequestBody @Valid TotalTimeRequestDTO totalTimeRequestDTO) {
        return calculatorService.calculateTotalTime(totalTimeRequestDTO);
    }
}
