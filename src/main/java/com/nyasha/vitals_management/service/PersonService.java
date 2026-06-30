package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.command.PersonUpdateCommand;
import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.PersonUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@Validated
public class PersonService {

    private final CommandGateway commandGateway;

    public PersonService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public String createPerson(PersonCreateRequest request) {
        PersonCreateCommand command = new PersonCreateCommand();

        String personId = UUID.randomUUID().toString();

        command.setPersonId(personId);
        command.setName(request.getName());
        command.setDateOfBirth(request.getDateOfBirth());
        command.setGender(request.getGender());
        command.setAddress(request.getAddress());
        command.setReligion(request.getReligion());
        command.setNationality(request.getNationality());

        log.info("Generated personId: {}", personId);

        commandGateway.sendAndWait(command);
        return personId;
    }

    public String updatePerson(
            String personId,
            PersonUpdateRequest request) {

        PersonUpdateCommand command = new PersonUpdateCommand();

        command.setPersonId(personId);
        command.setAddress(request.getAddress());

        commandGateway.sendAndWait(command);

        return personId;
    }

    public void deletePerson(String personId) {

        PersonDeleteCommand command =
                new PersonDeleteCommand(personId);

        commandGateway.sendAndWait(command);
    }
}
