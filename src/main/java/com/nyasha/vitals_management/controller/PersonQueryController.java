package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.query.GetAllPersonQuery;
import com.nyasha.vitals_management.query.GetPersonByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<Person> getAllPerson() {

        GetAllPersonQuery getAllPersonQuery = new GetAllPersonQuery();

        List<Person> personList = queryGateway.query(getAllPersonQuery,
                ResponseTypes.multipleInstancesOf(Person.class)).join();
        return personList;
    }

    @GetMapping("/{id}")
    public Person getAllPerson(@PathVariable String id) {

        GetPersonByIdQuery getPersonByIdQuery = new GetPersonByIdQuery();
        getPersonByIdQuery.setPersonId(id);

        Person person = queryGateway.query(getPersonByIdQuery,
                ResponseTypes.instanceOf(Person.class)).join();
        return person;
    }
}
