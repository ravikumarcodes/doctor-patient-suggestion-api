package com.xcelore.doctorpatientapi.entity;

import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String speciality;  // ✅ renamed from 'specialization' to 'speciality'
    private String city;        // ✅ added city field

    // Constructors
    public Doctor() {}

    public Doctor(String name, String speciality, String city) {
        this.name = name;
        this.speciality = speciality;
        this.city = city;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
