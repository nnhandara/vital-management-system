package com.nyasha.vitals_management.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalCreateCommand {

    @TargetAggregateIdentifier
    private String vitalId;

    private String personId;
    private String bloodPressure;
    private Integer temperature;
    private Integer oxygenSaturation;
    private Integer respiratoryRate;
    private Integer pulse;
    private Integer heartRate;
    private LocalDate date;


    public VitalCreateCommand(String personId, String bloodPressure, Integer temperature, Integer oxygenSaturation, Integer respiratoryRate, Integer pulse, Integer heartRate, LocalDate date) {
        this.vitalId = UUID.randomUUID().toString();
        this.personId = personId;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.oxygenSaturation = oxygenSaturation;
        this.respiratoryRate = respiratoryRate;
        this.pulse = pulse;
        this.heartRate = heartRate;
        this.date = date;
    }
}
