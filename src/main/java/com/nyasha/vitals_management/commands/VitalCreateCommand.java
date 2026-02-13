package com.nyasha.vitals_management.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Data
public class VitalCreateCommand {

    @TargetAggregateIdentifier
    private String vitalId;
    private String personId;
    private String type;
    private String value;
    private LocalDate date;
}
