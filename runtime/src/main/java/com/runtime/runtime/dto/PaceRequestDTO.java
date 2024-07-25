package com.runtime.runtime.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class PaceRequestDTO {

    @NotNull(message = "Seconds cannot be null")
    @Min(value=0, message = "Seconds must be greater than or equal to 0")
    private int totalTimeSec;
    @NotNull(message = "Minutes cannot be null")
    @Min(value=0, message = "Minutes must be greater than or equal to 0")
    private int totalTimeMin;
    @NotNull(message = "Hours cannot be null")
    @Min(value=0, message = "Hours must be greater than or equal to 0")
    private int totalTimeHour;
    @NotNull(message = "Kilometer cannot be null")
    @Min(value=0, message = "Kilometer must be greater than or equal to 0")
    private int kilometer;
    @NotNull(message = "Meter cannot be null")
    @Min(value=0, message = "Meter must be greater than or equal to 0")
    private int meter;

}
