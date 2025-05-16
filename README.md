# Doctor-Patient Suggestion API

This Spring Boot application allows doctors and patients to be registered and suggests doctors based on the patient's symptom and location.

## Technologies Used
- Java 21
- Spring Boot 3
- Hibernate (JPA)
- H2 database
- Swagger
- Postman

## APIs
- **POST /api/doctors** – Add doctor
- **POST /api/patients** – Add patient
- **GET /api/suggestion/{patientId}** – Suggest doctor for patient

## Postman Collection
Included in this repo: `DoctorPatientAPIs.postman_collection.json`

## Suggestion Logic
- Arthritis, Back Pain, Tissue injuries → Orthopaedic
- Dysmenorrhea → Gynecology
- Skin infection, Skin burn → Dermatology
- Ear pain → ENT specialist

## Edge Cases
- City outside supported (Delhi, Noida, Faridabad) → `"We are still waiting to expand to your location"`
- No doctor for symptom in that city → `"There isn't any doctor present at your location for your symptom"`
