package com.nyasha.vitals_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity( name = "vital")
public class Vital {

    @Id
    private String vitalId;
    private String personId;
    private String type;
    private String value;
    private LocalDate date;
}
