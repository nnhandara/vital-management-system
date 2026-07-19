package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.entity.Vital;
import com.nyasha.vitals_management.repository.VitalRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VitalQueryController {

    private final VitalRepository vitalRepository;

    public VitalQueryController(VitalRepository vitalRepository) {
        this.vitalRepository = vitalRepository;
    }

    @QueryMapping
    public List<Vital> vitalsByPersonId(@Argument String personId) {
        return vitalRepository.findByPersonPersonId(personId);
    }
}