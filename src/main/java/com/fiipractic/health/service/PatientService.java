package com.fiipractic.health.service;

import com.fiipractic.health.model.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatient(Long id);

    Patient savePatient(Patient patient);

    List<Patient> getPatients();
}
