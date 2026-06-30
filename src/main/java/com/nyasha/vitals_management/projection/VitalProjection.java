package com.nyasha.vitals_management.projection;

import com.nyasha.vitals_management.entity.Person;
import com.nyasha.vitals_management.entity.Vital;
import com.nyasha.vitals_management.event.VitalCreateEvent;
import com.nyasha.vitals_management.repository.PersonRepository;
import com.nyasha.vitals_management.repository.VitalRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VitalProjection {

    private final VitalRepository vitalRepository;
    private final PersonRepository personRepository;

    @EventHandler
    public void onVitalProjection(VitalCreateEvent event) {

        Person person = personRepository.findById(event.getPersonId())
                .orElseThrow(() -> new IllegalStateException(
                        "Person not found: " + event.getPersonId()
                ));

        Vital vital = new Vital();

        vital.setVitalId(event.getVitalId());
        vital.setPerson(person);
        vital.setBloodPressure(event.getBloodPressure());
        vital.setTemperature(event.getTemperature());
        vital.setOxygenSaturation(event.getOxygenSaturation());
        vital.setRespiratoryRate(event.getRespiratoryRate());
        vital.setPulse(event.getPulse());
        vital.setHeartRate(event.getHeartRate());
        vital.setDate(event.getDate());
        vital.setCreatedAt(event.getCreatedAt());

        vitalRepository.save(vital);
    }

}
