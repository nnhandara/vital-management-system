package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonCreateRequest dto) {
        CompletableFuture personId = personService.createPerson(dto.getName(), dto.getGender(), dto.getDateOfBirth(), dto.getAddress(), dto.getNationality());
        return ResponseEntity.ok((String) personId.join());
    }



}
