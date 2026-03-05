package com.nyasha.vitals_management.query.handler;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.query.GetAllPersonQuery;
import com.nyasha.vitals_management.query.GetPersonByIdQuery;
import com.nyasha.vitals_management.repository.PersonRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonQueryHandler {

    @Autowired
    private PersonRepository personRepository;

    @QueryHandler
    public List<Person> getAllPerson(GetAllPersonQuery getAllPersonQuery) {
        return personRepository.findAll();
    }

    @QueryHandler
    public Person getPerson(GetPersonByIdQuery getPersonById) {
        return personRepository.findById(getPersonById.getPersonId()).orElseThrow(() -> new RuntimeException("Person not found: " ));
    }



}
