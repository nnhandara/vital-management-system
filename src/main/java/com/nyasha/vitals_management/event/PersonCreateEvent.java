package com.nyasha.vitals_management.event;



import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PersonCreateEvent {

    private String personId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    private String nationality;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PersonCreateEvent(String personId, String name, String gender, LocalDate dateOfBirth, String address, String nationality) {
        this.personId = personId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationality = nationality;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


}
