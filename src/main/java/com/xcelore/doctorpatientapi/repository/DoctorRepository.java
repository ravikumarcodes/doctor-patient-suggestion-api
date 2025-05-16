package com.xcelore.doctorpatientapi.repository;

import com.xcelore.doctorpatientapi.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
