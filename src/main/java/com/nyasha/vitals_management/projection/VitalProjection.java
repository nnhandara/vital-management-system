package com.nyasha.vitals_management.projection;

import com.nyasha.vitals_management.entity.Vital;
import com.nyasha.vitals_management.events.VitalCreateEvent;
import com.nyasha.vitals_management.repository.VitalRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VitalProjection {

    private final VitalRepository vitalRepository;

    @EventHandler
    public void onVitalProjection(VitalCreateEvent vitalCreateEvent){
        Vital vital = new Vital();
        vital.setVitalId(vitalCreateEvent.getVitalId());
        vital.setPersonId(vitalCreateEvent.getPersonId());
        vital.setBloodPressure(vitalCreateEvent.getBloodPressure());
        vital.setTemperature(vitalCreateEvent.getTemperature());
        vital.setOxygenSaturation(vitalCreateEvent.getOxygenSaturation());
        vital.setRespiratoryRate(vitalCreateEvent.getRespiratoryRate());
        vital.setPulse(vitalCreateEvent.getPulse());
        vital.setHeartRate(vitalCreateEvent.getHeartRate());
        vital.setDate(vitalCreateEvent.getDate());
        vitalRepository.save(vital);
    }
}
