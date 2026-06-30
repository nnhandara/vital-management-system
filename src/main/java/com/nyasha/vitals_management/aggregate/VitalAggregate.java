package com.nyasha.vitals_management.aggregate;

import com.nyasha.vitals_management.command.VitalCreateCommand;
import com.nyasha.vitals_management.event.VitalCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class VitalAggregate {

    @AggregateIdentifier
    private String vitalId;

    protected VitalAggregate(){
    }

    @CommandHandler
    public VitalAggregate(VitalCreateCommand command) {
        apply(new VitalCreateEvent(
                command.getVitalId(),
                command.getPersonId(),
                command.getBloodPressure(),
                command.getTemperature(),
                command.getOxygenSaturation(),
                command.getRespiratoryRate(),
                command.getPulse(),
                command.getHeartRate(),
                command.getDate()
        ));
    }

    @EventSourcingHandler
    public void on(VitalCreateEvent event) {
        this.vitalId = event.getVitalId();
    }


}
