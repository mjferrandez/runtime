package com.runtime.runtime.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class TotalTimeRequestDTO {

    @NotNull(message = "Minutes cannot be null")
    @Min(value=0, message = "Minutes must be greater than or equal to 0")
    private int paceMin;
    @NotNull(message = "Seconds cannot be null")
    @Min(value=0,message = "Seconds must be greater than or equal to 0")
    private int paceSec;
    @NotNull(message = "Kilometer cannot be null")
    @Min(value=0, message = "Kilometer must be greater than or equal to 0")
    private int kilometer;
    @NotNull(message = "Meter cannot be null")
    @Min(value=0, message = "Meter must be greater than or equal to 0")
    private int meter;
}
