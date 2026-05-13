package com.nyasha.vitals_management.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchPersonsQuery {
    private String name;

    public SearchPersonsQuery(String name) {
        this.name = name;
    }

}
