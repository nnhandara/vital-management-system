package com.nyasha.vitals_management.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalCreateEvent {

    private String vitalId;
    private String personId;
    private String bloodPressure;
    private Integer temperature;
    private Integer oxygenSaturation;
    private Integer respiratoryRate;
    private Integer pulse;
    private Integer heartRate;
    private LocalDate date;

}
