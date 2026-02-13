package com.nyasha.vitals_management.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonCreateCommand {
    @TargetAggregateIdentifier
    private UUID personId;

    private String name;
    private String gender;
    private LocalDate dateOfBirth;


    public PersonCreateCommand(String name, String gender, LocalDate dateOfBirth) {
        this.personId = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }


}
