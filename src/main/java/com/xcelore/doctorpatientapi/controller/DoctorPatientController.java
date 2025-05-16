package com.xcelore.doctorpatientapi.controller;

import com.xcelore.doctorpatientapi.entity.Doctor;
import com.xcelore.doctorpatientapi.entity.Patient;
import com.xcelore.doctorpatientapi.repository.DoctorRepository;
import com.xcelore.doctorpatientapi.repository.PatientRepository;
import com.xcelore.doctorpatientapi.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorPatientController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @GetMapping("/suggestion/{patientId}")
    public String suggestDoctor(@PathVariable Long patientId) {
        return suggestionService.suggestDoctor(patientId);
    }
}
