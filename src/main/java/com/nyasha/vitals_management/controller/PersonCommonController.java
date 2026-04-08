package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.dto.PersonUpdateRequest;
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

    @PostMapping(value = "create")
    public CompletableFuture<String> createPerson(@RequestBody @Valid PersonCreateCommand personCreateCommand) {
        return personService.createPerson(personCreateCommand);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable String id,
                                               @RequestBody PersonUpdateRequest dto) {
        CompletableFuture<String> personId = personService.updatePerson(id, dto.getAddress());
        return ResponseEntity.ok(personId.join());
    }
    @DeleteMapping(value = "delete/{id}")
    public CompletableFuture<String> deletePerson(@PathVariable String id) {
        PersonDeleteCommand command = new PersonDeleteCommand(id);
        return personService.deletePerson(command);
    }




}
