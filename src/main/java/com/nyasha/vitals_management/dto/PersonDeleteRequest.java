package com.nyasha.vitals_management.dto;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class PersonDeleteRequest {
    @TargetAggregateIdentifier
    private String personId;

}
