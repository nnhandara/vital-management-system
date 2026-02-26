package com.nyasha.vitals_management.aggregate;

import com.nyasha.vitals_management.command.PersonCreateCommand;
import com.nyasha.vitals_management.command.PersonDeleteCommand;
import com.nyasha.vitals_management.command.PersonUpdateCommand;
import com.nyasha.vitals_management.event.PersonCreateEvent;
import com.nyasha.vitals_management.event.PersonDeleteEvent;
import com.nyasha.vitals_management.event.PersonUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PersonAggregate {

    @AggregateIdentifier
    private String personId;
    private String address;

    protected PersonAggregate(){
    }

    @CommandHandler
    public PersonAggregate(PersonCreateCommand command) {
        apply(new PersonCreateEvent(
                command.getPersonId(),
                command.getName(),
                command.getGender(),
                command.getDateOfBirth(),
                command.getAddress(),
                command.getNationality()
        ));
    }
    @EventSourcingHandler
    public void on(PersonCreateEvent event) {
        this.personId = event.getPersonId();
        this.address = event.getAddress();

    }

    @CommandHandler
    public void handle(PersonUpdateCommand command) {
        apply(new PersonUpdateEvent(
                command.getPersonId(),
                command.getAddress()
        ));
    }
    @EventSourcingHandler
    public void on(PersonUpdateEvent event) {
        this.address = event.getAddress();
    }

    @CommandHandler
    public void handle(PersonDeleteCommand command) {
        AggregateLifecycle.apply(new PersonDeleteEvent(
                command.getPersonId()
        ));
    }
    @EventSourcingHandler
    public void on(PersonDeleteEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
