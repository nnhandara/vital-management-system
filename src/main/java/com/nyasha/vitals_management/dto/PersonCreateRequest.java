package com.nyasha.vitals_management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonCreateRequest {

    private String name;
    private String gender;
    private LocalDate dateOfBirth;
}
