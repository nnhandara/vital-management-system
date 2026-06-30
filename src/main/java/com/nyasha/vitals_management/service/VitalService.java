package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.VitalCreateCommand;
import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.VitalCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class VitalService {

    private final CommandGateway commandGateway;

    public String createVital(String personId, VitalCreateRequest request) {

        String vitalId = UUID.randomUUID().toString();

        VitalCreateCommand command = new VitalCreateCommand();

        command.setVitalId(vitalId);
        command.setPersonId(personId);
        command.setBloodPressure(request.getBloodPressure());
        command.setTemperature(request.getTemperature());
        command.setOxygenSaturation(request.getOxygenSaturation());
        command.setRespiratoryRate(request.getRespiratoryRate());
        command.setPulse(request.getPulse());
        command.setHeartRate(request.getHeartRate());
        command.setDate(request.getDate());

        commandGateway.sendAndWait(command);

        return vitalId;
    }
}
