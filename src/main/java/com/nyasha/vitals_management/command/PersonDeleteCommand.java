package com.nyasha.vitals_management.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
public class PersonDeleteCommand {

    @TargetAggregateIdentifier
    private String personId;

    public PersonDeleteCommand(String personId) {
        this.personId = personId;
    }

}
