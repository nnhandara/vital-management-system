package com.nyasha.vitals_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity( name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    @Id
    @Column(name = "person_id", length = 36, columnDefinition = "VARCHAR(36)")
    private String personId;

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String nationality;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Vital> vitals;

    /*
## CascadeType.ALL
This means all operations on Person cascade to Vital.
All associated Vital records are automatically deleted.

## orphanRemoval = true
If a Vital is removed from the list, it is deleted from the database.
That Vital row is deleted from the database, not just unlinked.
*/

}

