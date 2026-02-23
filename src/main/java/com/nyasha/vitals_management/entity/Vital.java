package com.nyasha.vitals_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity( name = "vital")
@AllArgsConstructor
@NoArgsConstructor
public class Vital {

    @Id
    @Column(name = "vital_id")
    private String vitalId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false, columnDefinition = "VARCHAR(36)")
    private Person person;

   /*
   ## fetch = FetchType.LAZY
   This controls when the Person object is loaded from the database.
   LAZY → Person is loaded only when accessed
   EAGER → Person is loaded immediately

   ## optional = false
   This means: A Vital must always have a Person
   JPA enforces this at the object level
   You cannot persist a Vital without setting person

   ## nullable = false
   Database-level constraint
   The column cannot be NULL
    */

    private String bloodPressure;
    private Integer temperature;
    private Integer oxygenSaturation;
    private Integer respiratoryRate;
    private Integer pulse;
    private Integer heartRate;
    private LocalDate date;
    private LocalDateTime createdAt;

}
