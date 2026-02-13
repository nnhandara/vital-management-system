package com.nyasha.vitals_management.projection;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.events.PersonCreateEvent;
import com.nyasha.vitals_management.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PersonProjection {

    private final PersonRepository personRepository;
    @EventHandler
    public void onPersonProjection(PersonCreateEvent personCreateEvent) {
        Person person = new Person();
        person.setPersonId(UUID.fromString(String.valueOf(personCreateEvent.getPersonId())));
                person.setName(personCreateEvent.getName());
                person.setGender(personCreateEvent.getGender());
                person.setDateOfBirth(personCreateEvent.getDateOfBirth());
                person.setCreatedAt(personCreateEvent.getCreatedAt());
                person.setUpdatedAt(personCreateEvent.getUpdatedAt());
                personRepository.save(person);

    }
}
