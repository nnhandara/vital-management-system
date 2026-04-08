package com.nyasha.vitals_management.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonCreateCommand {
    @TargetAggregateIdentifier
    private String personId;

    @NonNull
    private String name;
    @NonNull
    private String gender;
    @NonNull
    private LocalDate dateOfBirth;
    private String address;
    private String nationality;
    private String religion;


}
