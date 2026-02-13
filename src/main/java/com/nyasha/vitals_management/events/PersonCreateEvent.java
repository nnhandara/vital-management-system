package com.nyasha.vitals_management.events;



import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PersonCreateEvent {

    private UUID personId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PersonCreateEvent(UUID personId, String name, String gender, LocalDate dateOfBirth) {
        this.personId = personId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


}
