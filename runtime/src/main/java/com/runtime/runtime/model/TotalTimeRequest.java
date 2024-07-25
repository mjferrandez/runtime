package com.runtime.runtime.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "totalTimeRequest")
public class TotalTimeRequest extends BaseRequest {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distance_id")
    private Distance distance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pace_id")
    private Pace pace;
}
