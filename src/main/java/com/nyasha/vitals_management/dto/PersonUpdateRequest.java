package com.nyasha.vitals_management.dto;

import lombok.Data;

@Data
public class PersonUpdateRequest {
    private String personId;

    private String address;
}
