package com.runtime.runtime.service;

import com.runtime.runtime.dto.*;
import com.runtime.runtime.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapperServiceTest {

    @InjectMocks
    private MapperService mapperService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDistanceRequestDTOToDistanceRequestEntity(){

        // Given
        DistanceRequestDTO distanceRequestDTO = new DistanceRequestDTO();
        distanceRequestDTO.setPaceSec(30);
        distanceRequestDTO.setPaceMin(5);
        distanceRequestDTO.setTotalTimeSec(20);
        distanceRequestDTO.setTotalTimeMin(40);
        distanceRequestDTO.setTotalTimeHour(1);

        // When
        DistanceRequest result = mapperService.toEntity(distanceRequestDTO);

        // Then
        assertNotNull(result);
        assertNotNull(result.getPace());
        assertEquals(30, result.getPace().getSec());
        assertEquals(5, result.getPace().getMin());
        assertNotNull(result.getTotalTime());
        assertEquals(20, result.getTotalTime().getSec());
        assertEquals(40, result.getTotalTime().getMin());
        assertEquals(1, result.getTotalTime().getHour());
    }

    @Test
    public void testDistanceToDistanceDTO(){

        // Given: A Distance entity with test data
        Distance distance = new Distance();
        distance.setKilometer(5);
        distance.setMeter(250);

        // When: The method toDTO is called
        DistanceDTO result = mapperService.toDTO(distance);

        // Then: The data should be mapped correctly
        assertNotNull(result);
        assertEquals(5, result.getKilometer());
        assertEquals(250, result.getMeter());

    }

    @Test
    public void testTotalTimeRequestDTOToTotalTimeRequestEntity(){

        // Given: A TotalTimeRequestDTO with test data
        TotalTimeRequestDTO totalTimeRequestDTO = new TotalTimeRequestDTO();
        totalTimeRequestDTO.setMeter(1000);
        totalTimeRequestDTO.setKilometer(10);
        totalTimeRequestDTO.setPaceSec(45);
        totalTimeRequestDTO.setPaceMin(5);

        // When: The method toEntity is called
        TotalTimeRequest result = mapperService.toEntity(totalTimeRequestDTO);

        // Then: The data should be mapped correctly
        assertNotNull(result);
        assertNotNull(result.getDistance());
        assertEquals(1000, result.getDistance().getMeter());
        assertEquals(10, result.getDistance().getKilometer());
        assertNotNull(result.getPace());
        assertEquals(45, result.getPace().getSec());
        assertEquals(5, result.getPace().getMin());

    }

    @Test
    public void testTotalTimeToTotalTimeDTO(){

        // Given: A TotalTime entity with test data
        TotalTime totalTime = new TotalTime();
        totalTime.setHour(2);
        totalTime.setMin(30);
        totalTime.setSec(45);

        // When: The method toDTO is called
        TotalTimeDTO result = mapperService.toDTO(totalTime);

        // Then: The data should be mapped correctly
        assertNotNull(result);
        assertEquals(2, result.getHour());
        assertEquals(30, result.getMin());
        assertEquals(45, result.getSec());

    }

    @Test
    public void testPaceRequestDTOToPaceRequestEntity(){

        // Given: A PaceRequestDTO with test data
        PaceRequestDTO paceRequestDTO = new PaceRequestDTO();
        paceRequestDTO.setMeter(500);
        paceRequestDTO.setKilometer(5);
        paceRequestDTO.setTotalTimeSec(30);
        paceRequestDTO.setTotalTimeMin(20);
        paceRequestDTO.setTotalTimeHour(1);

        // When: The method toEntity is called
        PaceRequest result = mapperService.toEntity(paceRequestDTO);

        // Then: The data should be mapped correctly
        assertNotNull(result);
        assertNotNull(result.getDistance());
        assertEquals(500, result.getDistance().getMeter());
        assertEquals(5, result.getDistance().getKilometer());
        assertNotNull(result.getTotalTime());
        assertEquals(30, result.getTotalTime().getSec());
        assertEquals(20, result.getTotalTime().getMin());
        assertEquals(1, result.getTotalTime().getHour());

    }

    @Test
    public void testPaceToPaceDTO(){

        // Given: A Pace entity with test data
        Pace pace = new Pace();
        pace.setSec(45);
        pace.setMin(5);

        // When: The method toDTO is called
        PaceDTO result = mapperService.toDTO(pace);

        // Then: The data should be mapped correctly
        assertNotNull(result);
        assertEquals(45, result.getSec());
        assertEquals(5, result.getMin());

    }


}
