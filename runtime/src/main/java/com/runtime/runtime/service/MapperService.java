package com.runtime.runtime.service;

import com.runtime.runtime.dto.*;
import com.runtime.runtime.model.*;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    public DistanceRequest toEntity(DistanceRequestDTO distanceRequestDTO) {

        if (distanceRequestDTO == null) {
            return null;
        }

        DistanceRequest distanceRequest = new DistanceRequest();

        Pace pace = new Pace();
        pace.setSec(distanceRequestDTO.getPaceSec());
        pace.setMin(distanceRequestDTO.getPaceMin());
        distanceRequest.setPace(pace);

        TotalTime totalTime = new TotalTime();
        totalTime.setSec(distanceRequestDTO.getTotalTimeSec());
        totalTime.setMin(distanceRequestDTO.getTotalTimeMin());
        totalTime.setHour(distanceRequestDTO.getTotalTimeHour());

        distanceRequest.setTotalTime(totalTime);

        return distanceRequest;
    }

    public PaceRequest toEntity(PaceRequestDTO paceRequestDTO) {

        if (paceRequestDTO == null) {
            return null;
        }

        PaceRequest paceRequest = new PaceRequest();

        Distance distance = new Distance();
        distance.setMeter(paceRequestDTO.getMeter());
        distance.setKilometer(paceRequestDTO.getKilometer());
        paceRequest.setDistance(distance);

        TotalTime totalTime = new TotalTime();
        totalTime.setSec(paceRequestDTO.getTotalTimeSec());
        totalTime.setMin(paceRequestDTO.getTotalTimeMin());
        totalTime.setHour(paceRequestDTO.getTotalTimeHour());

        paceRequest.setTotalTime(totalTime);

        return paceRequest;
    }

    public TotalTimeRequest toEntity(TotalTimeRequestDTO totalTimeRequestDTO) {

        if (totalTimeRequestDTO == null) {
            return null;
        }

        TotalTimeRequest totalTimeRequest = new TotalTimeRequest();

        Distance distance = new Distance();
        distance.setMeter(totalTimeRequestDTO.getMeter());
        distance.setKilometer(totalTimeRequestDTO.getKilometer());
        totalTimeRequest.setDistance(distance);

        Pace pace = new Pace();
        pace.setSec(totalTimeRequestDTO.getPaceSec());
        pace.setMin(totalTimeRequestDTO.getPaceMin());
        totalTimeRequest.setPace(pace);

        return totalTimeRequest;
    }

    public TotalTimeDTO toDTO(TotalTime totalTime){
        if (totalTime == null) {
            return null;
        }
        TotalTimeDTO totalTimeDTO = new TotalTimeDTO();
        totalTimeDTO.setHour(totalTime.getHour());
        totalTimeDTO.setMin(totalTime.getMin());
        totalTimeDTO.setSec(totalTime.getSec());

        return totalTimeDTO;
    }

    public DistanceDTO toDTO(Distance distance){
        if (distance == null) {
            return null;
        }

        DistanceDTO distanceDTO = new DistanceDTO();
        distanceDTO.setKilometer(distance.getKilometer());
        distanceDTO.setMeter(distance.getMeter());

        return  distanceDTO;
    }

    public PaceDTO toDTO(Pace pace){
        if (pace == null) {
            return null;
        }

        PaceDTO paceDTO = new PaceDTO();
        paceDTO.setSec(pace.getSec());
        paceDTO.setMin(pace.getMin());

        return paceDTO;
    }



}
