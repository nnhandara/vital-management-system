package com.nyasha.vitals_management.controller;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.query.GetAllPersonQuery;
import com.nyasha.vitals_management.query.GetPersonByIdQuery;
import com.nyasha.vitals_management.query.SearchPersonsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonGraphQLController {

    private final QueryGateway queryGateway;

    public PersonGraphQLController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @QueryMapping
    public List<Person> getAllPerson() {
        return queryGateway.query(
                new GetAllPersonQuery(),
                ResponseTypes.multipleInstancesOf(Person.class)
        ).join();
    }

    @QueryMapping
    public Person getPersonById(@Argument String personId) {
        return queryGateway.query(
                new GetPersonByIdQuery(personId),
                ResponseTypes.instanceOf(Person.class)
        ).join();
    }

    @QueryMapping
    public List<Person> searchPersonQuery(@Argument String name) {
        return queryGateway.query(
                new SearchPersonsQuery(name),
                ResponseTypes.multipleInstancesOf(Person.class)
        ).join();
    }
}
