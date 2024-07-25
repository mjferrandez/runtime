package com.runtime.runtime.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "totalTimeRequest")
public class TotalTimeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distance_id")
    private Distance distance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pace_id")
    private Pace pace;
}
