package com.nyasha.vitals_management.event;

import lombok.Data;

@Data
public class PersonUpdateEvent {

    private String personId;
    private String address;

    public PersonUpdateEvent(String personId, String address) {
        this.personId = personId;
        this.address = address;
    }
}
