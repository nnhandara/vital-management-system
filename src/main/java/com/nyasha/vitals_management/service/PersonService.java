package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.command.PersonUpdateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final CommandGateway commandGateway;


    public CompletableFuture createPerson(String name,
                                          String gender,
                                          LocalDate dateOfBirth,
                                          String address,
                                          String nationality) {
       PersonCreateCommand command =
               new PersonCreateCommand(
                       name,
                       gender,
                       dateOfBirth,
                       address,
                       nationality);
        log.info("Generated personId: {}", command.getPersonId());
      return commandGateway.send(command).thenApply(result -> command.getPersonId());
    }

    public CompletableFuture updatePerson(String personId, String address) {

        PersonUpdateCommand command =
               new PersonUpdateCommand(
                       personId,
                       address
               );
        return commandGateway.send(command).thenApply(result -> command.getPersonId());
    }

    public CompletableFuture<String> deletePerson(String personId) {
        return commandGateway.send(new PersonDeleteCommand(personId));
    }



}
