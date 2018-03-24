package com.fiipractic.health.db;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HealthDB {
    private Map<Long, Doctor> doctors;
    private Map<Long, Patient> patients;

    public HealthDB() {
        // Adding doctors
        this.doctors = new HashMap<>();
        Doctor doctor1 = new Doctor();
        doctor1.setId(1L);
        doctor1.setName("Pomo Alex");
        doctor1.setFunction("Cardiolog");
        doctors.put(doctor1.getId(), doctor1);
        Doctor doctor2 = new Doctor();
        doctor2.setId(2L);
        doctor2.setName("Marius Gafiteanu");
        doctor2.setFunction("Pediatru");
        doctors.put(doctor2.getId(), doctor2);
        // Adding patients
        this.patients = new HashMap<>();
        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setName("Martincu Petru");
        patients.put(patient1.getId(), patient1);
        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setName("Gritcau Sorinel");
        patients.put(patient2.getId(), patient2);
    }

    public List<Doctor> getDoctors() {
        return new ArrayList<>(doctors.values());
    }

    public Doctor getDoctor(Long id) {
        return doctors.get(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        this.doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients.values());
    }

    public Patient getPatient(Long id) {
        return patients.get(id);
    }

    public Patient savePatient(Patient patient) {
        this.patients.put(patient.getId(), patient);
        return patient;
    }
}
