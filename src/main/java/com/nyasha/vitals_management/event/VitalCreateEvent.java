package com.nyasha.vitals_management.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;


    public VitalCreateEvent(String vitalId, String personId, String bloodPressure, Integer temperature, Integer oxygenSaturation, Integer respiratoryRate, Integer pulse, Integer heartRate, LocalDate date) {
        this.vitalId = vitalId;
        this.personId = personId;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.oxygenSaturation = oxygenSaturation;
        this.respiratoryRate = respiratoryRate;
        this.pulse = pulse;
        this.heartRate = heartRate;
        this.date = date;
        this.createdAt = LocalDateTime.now();
    }
}
