package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.VitalCreateRequest;
import com.nyasha.vitals_management.service.VitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("{personId}/vital")
@RequiredArgsConstructor
public class VitalController {

    private final VitalService vitalService;

    @PostMapping()
    public ResponseEntity<String> createVital(@RequestBody VitalCreateRequest dto){
        CompletableFuture vitalId = vitalService.createVital(dto.getPersonId(),
                dto.getBloodPressure(), dto.getTemperature(), dto.getOxygenSaturation(),
                dto.getRespiratoryRate(), dto.getPulse(), dto.getHeartRate(), dto.getDate());
        return ResponseEntity.ok((String) vitalId.join());

    }
}
