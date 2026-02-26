package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.command.VitalCreateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class VitalService {

    private final CommandGateway commandGateway;

    public CompletableFuture createVital(String personId,
                                               String bloodPressure,
                                               Integer temperature,
                                               Integer oxygenSaturation,
                                               Integer respiratoryRate,
                                               Integer pulse,
                                               Integer heartRate,
                                               LocalDate date){
        VitalCreateCommand command = new VitalCreateCommand(
                personId, bloodPressure, temperature, oxygenSaturation, respiratoryRate, pulse, heartRate, date);
        return commandGateway.send(command).thenApply(result  -> command.getVitalId());

    }
}
