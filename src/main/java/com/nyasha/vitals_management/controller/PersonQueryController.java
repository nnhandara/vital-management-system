package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.query.GetAllPersonQuery;
import com.nyasha.vitals_management.query.GetPersonByIdQuery;
import com.nyasha.vitals_management.query.SearchPersonsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonQueryController {

    @Autowired
    private QueryGateway queryGateway;

//    @GetMapping
//    public List<Person> getAllPerson() {
//
//        List<Person> personList = queryGateway.query(new GetAllPersonQuery(),
//                ResponseTypes.multipleInstancesOf(Person.class)).join();
//        return personList;
//    }

    @GetMapping
    public List<Person> getAllPerson() {
        return queryGateway.query(new GetAllPersonQuery(),
                ResponseTypes.multipleInstancesOf(Person.class)).join();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable String id) {

        GetPersonByIdQuery query = new GetPersonByIdQuery();
        query.setPersonId(id);

        return queryGateway.query(
                query,
                ResponseTypes.instanceOf(Person.class)
        ).join();
    }

    @GetMapping("/search")
    public List<Person> searchPersons(@RequestParam String name) {

        SearchPersonsQuery query = new SearchPersonsQuery();
        query.setName(name);

        return queryGateway.query(
                query,
                ResponseTypes.multipleInstancesOf(Person.class)
        ).join();
    }


}