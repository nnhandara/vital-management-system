package com.nyasha.vitals_management.events;

import lombok.Data;

@Data
public class VitalCreateEvent {

    private String vitalId;
    private String personId;
    private String type;
    private String value;
    private String date;
}
