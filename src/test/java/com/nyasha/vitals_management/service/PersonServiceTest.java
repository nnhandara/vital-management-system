package com.nyasha.vitals_management.service;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.command.PersonUpdateCommand;
import com.nyasha.vitals_management.dto.PersonCreateRequest;
import com.nyasha.vitals_management.dto.PersonUpdateRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    private CommandGateway commandGateway;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        commandGateway = mock(CommandGateway.class);
        personService = new PersonService(commandGateway);
    }

    @Test
    void shouldCreatePerson() {

        PersonCreateRequest request = new PersonCreateRequest();
        request.setName("John");
        request.setGender("Male");
        request.setDateOfBirth(LocalDate.of(2000, 10, 9));
        request.setAddress("Harare");
        request.setReligion("Christian");
        request.setNationality("Zimbabwean");

        String personId = personService.createPerson(request);

        assertNotNull(personId);

        ArgumentCaptor<PersonCreateCommand> captor =
                ArgumentCaptor.forClass(PersonCreateCommand.class);

        verify(commandGateway).sendAndWait(captor.capture());

        PersonCreateCommand command = captor.getValue();

        assertEquals("John", command.getName());
        assertEquals("Male", command.getGender());
        assertEquals(LocalDate.of(2000, 10, 9), command.getDateOfBirth());
        assertEquals("Harare", command.getAddress());
        assertEquals(personId, command.getPersonId());
    }

    @Test
    void shouldUpdatePerson() {

        String personId = "123";

        PersonUpdateRequest request = new PersonUpdateRequest();
        request.setAddress("Bulawayo");

        personService.updatePerson(personId, request);

        ArgumentCaptor<PersonUpdateCommand> captor =
                ArgumentCaptor.forClass(PersonUpdateCommand.class);

        verify(commandGateway).sendAndWait(captor.capture());

        PersonUpdateCommand command = captor.getValue();

        assertEquals("123", command.getPersonId());
        assertEquals("Bulawayo", command.getAddress());
    }

    @Test
    void shouldDeletePerson() {

        String personId = "123";

        personService.deletePerson(personId);

        ArgumentCaptor<PersonDeleteCommand> captor =
                ArgumentCaptor.forClass(PersonDeleteCommand.class);

        verify(commandGateway).sendAndWait(captor.capture());

        PersonDeleteCommand command = captor.getValue();

        assertEquals("123", command.getPersonId());
    }

    @Test
    void shouldSendDeleteCommand() {

        personService.deletePerson("123");

        verify(commandGateway, times(1))
                .sendAndWait(any(PersonDeleteCommand.class));
    }
}
