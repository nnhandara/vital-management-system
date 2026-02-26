package com.nyasha.vitals_management.command;

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
    private String personId;

    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    private String nationality;


    public PersonCreateCommand(String name, String gender, LocalDate dateOfBirth, String address, String nationality) {
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationality = nationality;
    }


}
