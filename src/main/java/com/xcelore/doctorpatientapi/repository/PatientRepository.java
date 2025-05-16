package com.xcelore.doctorpatientapi.repository;

import com.xcelore.doctorpatientapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
