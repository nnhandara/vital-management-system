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
    public void onVitalProjection(VitalCreateEvent vitalCreateEvent){
        Person person = personRepository.findById(vitalCreateEvent.getPersonId())
                .orElseThrow(() -> new IllegalStateException("Person not found: " + vitalCreateEvent.getPersonId()));

        Vital vital = new Vital();
        vital.setPerson(person);
        vital.setVitalId(vitalCreateEvent.getVitalId());
        vital.setBloodPressure(vitalCreateEvent.getBloodPressure());
        vital.setTemperature(vitalCreateEvent.getTemperature());
        vital.setOxygenSaturation(vitalCreateEvent.getOxygenSaturation());
        vital.setRespiratoryRate(vitalCreateEvent.getRespiratoryRate());
        vital.setPulse(vitalCreateEvent.getPulse());
        vital.setHeartRate(vitalCreateEvent.getHeartRate());
        vital.setDate(vitalCreateEvent.getDate());
        vital.setCreatedAt(vitalCreateEvent.getCreatedAt());

        vitalRepository.save(vital);
    }

    private Person getReferenceById(String personId) {
        return personRepository.getReferenceByPersonId(personId);
    }
}
