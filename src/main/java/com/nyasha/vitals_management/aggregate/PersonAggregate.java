package com.nyasha.vitals_management.aggregate;

import com.nyasha.vitals_management.commands.PersonCreateCommand;
import com.nyasha.vitals_management.events.PersonCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PersonAggregate {

    @AggregateIdentifier
    private String personId;

    protected PersonAggregate(){
    }

    @CommandHandler
    public PersonAggregate(PersonCreateCommand command) {
        apply(new PersonCreateEvent(
                command.getPersonId(),
                command.getName(),
                command.getGender(),
                command.getDateOfBirth()
        ));
    }

    @EventSourcingHandler
    public void on(PersonCreateEvent event) {
        this.personId = String.valueOf(event.getPersonId());

    }
}
