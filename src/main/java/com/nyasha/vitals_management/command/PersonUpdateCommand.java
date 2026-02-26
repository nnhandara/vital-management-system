package com.nyasha.vitals_management.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class PersonUpdateCommand {

    @TargetAggregateIdentifier
    private final String personId;
    private final String address;

    public PersonUpdateCommand(String personId, String address) {
        this.personId = personId;
        this.address = address;
    }
}
