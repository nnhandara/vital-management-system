package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.VitalCreateRequest;
import com.nyasha.vitals_management.service.VitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("{personId}/vital")
@RequiredArgsConstructor
public class VitalController {

    private final VitalService vitalService;

    @PostMapping(value = "create")
    public ResponseEntity<String> createVital(@PathVariable String personId,
                                              @RequestBody VitalCreateRequest dto){
        CompletableFuture vitalId = vitalService.createVital(personId,
                dto.getBloodPressure(), dto.getTemperature(), dto.getOxygenSaturation(),
                dto.getRespiratoryRate(), dto.getPulse(), dto.getHeartRate(), dto.getDate());
        return ResponseEntity.ok((String) vitalId.join());

    }
}
