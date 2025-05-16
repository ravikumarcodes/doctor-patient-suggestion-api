package com.xcelore.doctorpatientapi.service;

import com.xcelore.doctorpatientapi.entity.Doctor;
import com.xcelore.doctorpatientapi.entity.Patient;
import com.xcelore.doctorpatientapi.repository.DoctorRepository;
import com.xcelore.doctorpatientapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    public String suggestDoctor(Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElse(null);

        if (patient == null) {
            return "Patient not found";
        }

        String city = patient.getCity();
        String symptom = patient.getSymptom();

        // Step 1: Check if city is valid
        if (!city.equalsIgnoreCase("Delhi") &&
            !city.equalsIgnoreCase("Noida") &&
            !city.equalsIgnoreCase("Faridabad")) {
            return "We are still waiting to expand to your location";
        }

        // Step 2: Determine speciality from symptom
        String speciality = getSpecialityFromSymptom(symptom);
        if (speciality == null) {
            return "We couldn't find a suitable speciality for your symptom";
        }

        // Step 3: Find matching doctors
        List<Doctor> doctors = doctorRepo.findAll();
        List<Doctor> matchingDoctors = doctors.stream()
                .filter(d -> d.getCity().equalsIgnoreCase(city)
                          && d.getSpeciality().equalsIgnoreCase(speciality))
                .collect(Collectors.toList());

        if (matchingDoctors.isEmpty()) {
            return "There isn't any doctor present at your location for your symptom";
        }

        // Step 4: Build doctor info response
        StringBuilder response = new StringBuilder("Suggested Doctors:\n");
        for (Doctor doctor : matchingDoctors) {
            response.append("- Dr. ").append(doctor.getName())
                    .append(" (").append(doctor.getSpeciality()).append(")\n");
        }

        return response.toString();
    }

    private String getSpecialityFromSymptom(String symptom) {
        symptom = symptom.toLowerCase();

        if (symptom.contains("arthritis") || symptom.contains("back pain") || symptom.contains("tissue")) {
            return "Orthopaedic";
        } else if (symptom.contains("dysmenorrhea")) {
            return "Gynecology";
        } else if (symptom.contains("skin")) {
            return "Dermatology";
        } else if (symptom.contains("ear")) {
            return "ENT specialist";
        }
        return null;
    }
}
