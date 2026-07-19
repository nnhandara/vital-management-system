package com.nyasha.vitals_management.repository;

import com.nyasha.vitals_management.entity.Vital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VitalRepository extends JpaRepository<Vital, String> {

    List<Vital> findByPersonPersonId(String personId);

}
