package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.PersonDeleteRequest;
import com.nyasha.vitals_management.dto.PersonUpdateRequest;
import com.nyasha.vitals_management.dto.VitalCreateRequest;
import com.nyasha.vitals_management.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "http://localhost:3040")
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonCommonController {

    private final PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody PersonCreateRequest personCreateRequest) {

        String personId = personService.createPerson(personCreateRequest);

        return ResponseEntity.ok(personId);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<String> updatePerson(
            @PathVariable String personId,
            @RequestBody PersonUpdateRequest personUpdateRequest) {

        String updatedPersonId =
                personService.updatePerson(personId, personUpdateRequest);

        return ResponseEntity.ok(updatedPersonId);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deletePerson(
            @PathVariable String personId) {

        personService.deletePerson(personId);

        return ResponseEntity.ok("Person deleted successfully");
    }

}
