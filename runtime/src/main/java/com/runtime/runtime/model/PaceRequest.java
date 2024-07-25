package com.runtime.runtime.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paceRequest")
public class PaceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distance_id")
    private Distance distance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "total_time_id")
    private TotalTime totalTime;


}
