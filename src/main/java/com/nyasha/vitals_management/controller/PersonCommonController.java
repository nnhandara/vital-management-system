package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.PersonUpdateRequest;
import com.nyasha.vitals_management.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonCommonController {

    private final PersonService personService;

    @PostMapping(value = "create")
    public ResponseEntity<String> createPerson(@RequestBody PersonCreateRequest dto) {
        CompletableFuture<String> personId = personService.createPerson(dto.getName(), dto.getGender(), dto.getDateOfBirth(), dto.getAddress(), dto.getNationality());
        return ResponseEntity.ok(personId.join());
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable("id") String id,
                                               @RequestBody PersonUpdateRequest dto) {
        CompletableFuture<String> personId = personService.updatePerson(id, dto.getAddress());
        return ResponseEntity.ok(personId.join());
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") String id) {
        CompletableFuture<String> personId = personService.deletePerson(id);
        return ResponseEntity.ok(personId.join());
    }




}
