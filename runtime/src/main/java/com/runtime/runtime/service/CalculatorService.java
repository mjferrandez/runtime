package com.runtime.runtime.service;

import com.runtime.runtime.dto.*;
import com.runtime.runtime.model.*;
import com.runtime.runtime.repository.DistanceRequestRepository;
import com.runtime.runtime.repository.PaceRequestRepository;
import com.runtime.runtime.repository.TotalTimeRepository;
import com.runtime.runtime.repository.TotalTimeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final PaceRequestRepository paceRequestRepository;

    private final DistanceRequestRepository distanceRequestRepository;

    private final TotalTimeRepository totalTimeRepository;

    private final MapperService mapperService;
    private final TotalTimeRequestRepository totalTimeRequestRepository;

    @Autowired
    public CalculatorService(PaceRequestRepository paceRequestRepository, DistanceRequestRepository distanceRequestRepository, TotalTimeRepository totalTimeRepository, MapperService mapperService, TotalTimeRequestRepository totalTimeRequestRepository) {
        this.paceRequestRepository = paceRequestRepository;
        this.distanceRequestRepository = distanceRequestRepository;
        this.totalTimeRepository = totalTimeRepository;
        this.mapperService = mapperService;
        this.totalTimeRequestRepository = totalTimeRequestRepository;
    }

    public  PaceDTO calculatePace(PaceRequestDTO paceRequestDTO){

        PaceRequest paceRequest = mapperService.toEntity(paceRequestDTO);

        //Request persistance
        paceRequestRepository.save(paceRequest);

        //Calculation
        Pace paceCalculated = paceCalculationOperation(paceRequest);

        return mapperService.toDTO(paceCalculated);
    }

    public Pace paceCalculationOperation(PaceRequest paceRequest){

        //Pace calculation
        double kilometers = (paceRequest.getDistance().getMeter()/1000.0) + paceRequest.getDistance().getKilometer();
        double totalTimeInMinutes = paceRequest.getTotalTime().getSec()/60.0 +
                paceRequest.getTotalTime().getMin() +
                (paceRequest.getTotalTime().getHour() * 60.0);

        double pace = totalTimeInMinutes/kilometers;

        int min = (int) pace;
        double fractionalPart = pace - min;
        int sec = (int) Math.round(fractionalPart * 60);

        Pace paceCalculated = new Pace();
        paceCalculated.setMin(min);
        paceCalculated.setSec(sec);

        return paceCalculated;
    }

    public DistanceDTO calculateDistance(DistanceRequestDTO distanceRequestDTO){

        DistanceRequest distanceRequest = mapperService.toEntity(distanceRequestDTO);

        //Save request
        distanceRequestRepository.save(distanceRequest);

        //Calculation
        Distance distanceCalculated = distanceCalculationOperation(distanceRequest);

        return mapperService.toDTO(distanceCalculated);
    }

    public Distance distanceCalculationOperation(DistanceRequest distanceRequest){

        //Calculate distance
        double totalTimeInSec = distanceRequest.getTotalTime().getSec() +
                (distanceRequest.getTotalTime().getMin()*60.0) +
                (distanceRequest.getTotalTime().getHour() * 3600.0);

        double paceInSec = (double) distanceRequest.getPace().getSec() +
                (double) distanceRequest.getPace().getMin()*60.0;

        double distance = totalTimeInSec/paceInSec;
        int kilometer = (int) distance;
        double fractionalPart = distance - kilometer;
        int meter = (int) Math.round(fractionalPart*1000);

        Distance distanceCalculated = new Distance();
        distanceCalculated.setKilometer(kilometer);
        distanceCalculated.setMeter(meter);

        return distanceCalculated;

    }

    public TotalTimeDTO calculateTotalTime(TotalTimeRequestDTO totalTimeRequestDTO){

        TotalTimeRequest totalTimeRequest = mapperService.toEntity(totalTimeRequestDTO);

        //Save request
        totalTimeRequestRepository.save(totalTimeRequest);

        //Calculation
        TotalTime totalTime = totalTimeCalculationOperation(totalTimeRequest);

        return mapperService.toDTO(totalTime);
    }

    public TotalTime totalTimeCalculationOperation(TotalTimeRequest totalTimeRequest){

        double paceInMin = totalTimeRequest.getPace().getMin() + (totalTimeRequest.getPace().getSec()/60.0);
        double distanceInKilometer = totalTimeRequest.getDistance().getKilometer() + (totalTimeRequest.getDistance().getMeter()/1000.0);

        //Totaltime calculation in minutes
        double totalTimeInMin= paceInMin*distanceInKilometer;

        //Totaltime calculation in hours
        double totalTimeInHours = totalTimeInMin/60.0;

        //Hours int
        int hourTotal = (int) totalTimeInHours;

        //Mins int
        double remainingMinutes = totalTimeInMin % 60;
        int minTotal = (int) remainingMinutes;

        //Secs int
        int secTotal = (int) ((remainingMinutes - minTotal)*60);

        TotalTime totalTime= new TotalTime();
        totalTime.setHour(hourTotal);
        totalTime.setMin(minTotal);
        totalTime.setSec(secTotal);

        return totalTime;
    }

}
