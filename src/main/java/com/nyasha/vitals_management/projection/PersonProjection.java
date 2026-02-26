package com.nyasha.vitals_management.projection;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.event.PersonCreateEvent;
import com.nyasha.vitals_management.event.PersonDeleteEvent;
import com.nyasha.vitals_management.event.PersonUpdateEvent;
import com.nyasha.vitals_management.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonProjection {

    private final PersonRepository personRepository;
    @EventHandler
    public void onPersonProjection(PersonCreateEvent personCreateEvent) {
        Person person = new Person();
        person.setPersonId(personCreateEvent.getPersonId());
                person.setName(personCreateEvent.getName());
                person.setGender(personCreateEvent.getGender());
                person.setDateOfBirth(personCreateEvent.getDateOfBirth());
                person.setAddress(personCreateEvent.getAddress());
                person.setNationality(personCreateEvent.getNationality());
                person.setCreatedAt(personCreateEvent.getCreatedAt());
                person.setUpdatedAt(personCreateEvent.getUpdatedAt());
                personRepository.save(person);

    }

    @EventHandler
    public void onPersonProjection(PersonUpdateEvent personUpdateEvent) {
        Person person = personRepository.getReferenceByPersonId(personUpdateEvent.getPersonId());
        person.setAddress(personUpdateEvent.getAddress());
        personRepository.save(person);
    }

    @EventHandler
    public void on(PersonDeleteEvent personDeleteEvent) {
        personRepository.deleteById(personDeleteEvent.getPersonId());
    }
}
