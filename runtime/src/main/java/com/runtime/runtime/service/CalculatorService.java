package com.runtime.runtime.service;

import com.runtime.runtime.model.*;
import com.runtime.runtime.repository.DistanceRequestRepository;
import com.runtime.runtime.repository.PaceRequestRepository;
import com.runtime.runtime.repository.TotalTimeRepository;
import com.runtime.runtime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private PaceRequestRepository paceRequestRepository;

    @Autowired
    private DistanceRequestRepository distanceRequestRepository;

    @Autowired
    private TotalTimeRepository totalTimeRepository;

    public  Pace calculatePace(PaceRequest paceRequest){

        //Pace calculation

        double kilometers = (paceRequest.getDistance().getMeter()/1000.0) + paceRequest.getDistance().getKilometer();
        double totalTime = (paceRequest.getTotalTime().getSec()/60.0) + paceRequest.getTotalTime().getMin() + (paceRequest.getTotalTime().getHour() * 60.0);

        double pace = totalTime/kilometers;

        int min = (int) pace;
        double fractionalPart = pace - min;
        int sec = (int) Math.round(fractionalPart * 60);

        Pace paceCalculated = new Pace();
        paceCalculated.setMin(min);
        paceCalculated.setSec(sec);

        //Request persistance
        paceRequestRepository.save(paceRequest);


        return paceCalculated;
    }

    public  Distance calculateDistance(DistanceRequest distanceRequest){

        //Calculate distance
        double totalTimeInSec = distanceRequest.getTotalTime().getSec() + (distanceRequest.getTotalTime().getMin()*60) + (distanceRequest.getTotalTime().getHour() * 60 * 60);
        double paceInSec = distanceRequest.getPace().getSec() + (distanceRequest.getPace().getMin()*60);

        double distance = totalTimeInSec/paceInSec;
        int kilometer = (int) distance;
        double fractionalPart = distance - kilometer;
        int meter = (int) Math.round(fractionalPart*1000);

        Distance distanceCalculated = new Distance();
        distanceCalculated.setKilometer(kilometer);
        distanceCalculated.setMeter(meter);

        //Save request
        distanceRequestRepository.save(distanceRequest);

        return distanceCalculated;
    }

    public  TotalTime calculateTotalTime(TotalTimeRequest  totalTimeRequest){

        double min = totalTimeRequest.getPace().getMin() + (totalTimeRequest.getPace().getSec()/60.0);
        double kilometer = totalTimeRequest.getDistance().getKilometer() + (totalTimeRequest.getDistance().getMeter()/1000.0);

        //Totaltime calculation in minutes
        double totalTimeInMin= min*kilometer;

        //Totaltime calculation in hours
        double hours = totalTimeInMin/60.0;

        //Hours int
        int hourTotal = (int) hours;

        //Mins int
        double remainingMinutes = totalTimeInMin % 60;
        int minTotal = (int) remainingMinutes;

        //Secs int
        int secTotal = (int) ((remainingMinutes - minTotal)*60);

        TotalTime totalTime= new TotalTime();
        totalTime.setHour(hourTotal);
        totalTime.setMin(minTotal);
        totalTime.setSec(secTotal);

        //Save request
        totalTimeRepository.save(totalTime);

        return totalTime;
    }

}
