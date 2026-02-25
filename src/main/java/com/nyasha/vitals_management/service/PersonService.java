package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.commands.PersonCreateCommand;
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
      return commandGateway.send(command).thenApply(result -> command.getPersonId());
    }

}
