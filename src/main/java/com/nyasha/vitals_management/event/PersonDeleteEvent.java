package com.nyasha.vitals_management.event;

import lombok.Data;

@Data
public class PersonDeleteEvent {
    private String personId;

    public PersonDeleteEvent(String personId) {
    }
}
