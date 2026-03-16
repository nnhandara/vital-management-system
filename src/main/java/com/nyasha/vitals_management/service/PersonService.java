package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.command.PersonUpdateCommand;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
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

    public CompletableFuture<String> createPerson(@Valid PersonCreateCommand personCreateCommand) {

        String personId = UUID.randomUUID().toString();
        personCreateCommand.setPersonId(personId);

        log.info("Generated personId: {}", personCreateCommand.getPersonId());

        return commandGateway.send(personCreateCommand)
                .thenApply(result -> personCreateCommand.getPersonId());
    }

    public CompletableFuture<String> updatePerson(PersonUpdateCommand personUpdateCommand) {
        PersonUpdateCommand command = new PersonUpdateCommand(personUpdateCommand.getPersonId(), personUpdateCommand.getAddress());
        return commandGateway.send(personUpdateCommand).thenApply(result -> personUpdateCommand.getPersonId());
    }

    public CompletableFuture<String> deletePerson(PersonDeleteCommand personDeleteCommand) {
        log.info("Deleting person with id: {}", personDeleteCommand.getPersonId());
        return commandGateway.send(personDeleteCommand).thenApply(result -> personDeleteCommand.getPersonId());
    }




    public CompletableFuture<String> updatePerson(String id, String address) {
        PersonUpdateCommand command = new PersonUpdateCommand(id, address);
        return commandGateway.send(command).thenApply(result -> command.getPersonId());
    }
}
