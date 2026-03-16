package com.nyasha.vitals_management.repository;


import com.nyasha.vitals_management.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, String> {

    Optional<Person> findByPersonId(String personId);

    Person getReferenceByPersonId(String personId);

}
