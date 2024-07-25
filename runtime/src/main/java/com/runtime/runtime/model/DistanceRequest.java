package com.runtime.runtime.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "distanceRequest")
public class DistanceRequest extends BaseRequest {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pace_id")
    private Pace pace;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "total_time_id")
    private TotalTime totalTime;

}
