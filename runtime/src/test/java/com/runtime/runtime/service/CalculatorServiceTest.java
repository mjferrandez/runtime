package com.runtime.runtime.service;

import com.runtime.runtime.dto.PaceDTO;
import com.runtime.runtime.dto.PaceRequestDTO;
import com.runtime.runtime.model.*;
import com.runtime.runtime.repository.DistanceRequestRepository;
import com.runtime.runtime.repository.PaceRequestRepository;
import com.runtime.runtime.repository.TotalTimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {


    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testPaceCalculationOperation(){

        //Given
        PaceRequest paceRequest = new PaceRequest();
        paceRequest.setDistance(Distance.builder().meter(20).kilometer(12).build());
        paceRequest.setTotalTime(TotalTime.builder().min(12).hour(1).sec(12).build());

        Pace pace = calculatorService.paceCalculationOperation(paceRequest);

        assertEquals(Pace.builder().min(6).sec(0).build(), pace);

    }

    @Test
    public void testDistanceCalculationOperation(){

        //Given
        DistanceRequest distanceRequest = new DistanceRequest();
        distanceRequest.setTotalTime(TotalTime.builder().min(12).hour(1).sec(12).build());
        distanceRequest.setPace(Pace.builder().min(6).sec(0).build());


        Distance distance = calculatorService.distanceCalculationOperation(distanceRequest);

        assertEquals(Distance.builder().meter(33).kilometer(12).build(), distance);


    }

    @Test
    public void testTotalTimeCalculationOperation(){

        //Given
        TotalTimeRequest totalTimeRequest = new TotalTimeRequest();
        totalTimeRequest.setPace(Pace.builder().min(6).sec(0).build());
        totalTimeRequest.setDistance(Distance.builder().meter(20).kilometer(12).build());

        TotalTime totalTime = calculatorService.totalTimeCalculationOperation(totalTimeRequest);

        assertEquals(TotalTime.builder().hour(1).min(12).sec(7).build(), totalTime);


    }

}
