package com.nyasha.vitals_management.repository;


import com.nyasha.vitals_management.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
