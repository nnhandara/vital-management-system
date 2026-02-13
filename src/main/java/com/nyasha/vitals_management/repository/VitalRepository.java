package com.nyasha.vitals_management.repository;

import com.nyasha.vitals_management.entity.Vital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalRepository extends JpaRepository<Vital, String> {
}
