package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.dto.VitalCreateRequest;
import com.nyasha.vitals_management.service.VitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3040")
@RestController
@RequestMapping("/{personId}/vital")
@RequiredArgsConstructor
public class VitalController {

    private final VitalService vitalService;

    @PostMapping("/create")
    public ResponseEntity<String> createVital(
            @PathVariable String personId,
            @RequestBody VitalCreateRequest request) {

        String vitalId = vitalService.createVital(personId, request);

        return ResponseEntity.ok(vitalId);
    }
}
