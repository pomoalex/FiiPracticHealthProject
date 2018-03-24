package com.fiipractic.health.controller;

import com.fiipractic.health.model.Patient;
import com.fiipractic.health.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Patient getDoctor(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public Patient saveDoctor(@RequestBody Patient doctor) {
        return patientService.savePatient(doctor);
    }

    @GetMapping
    public List<Patient> getDoctors() {
        return patientService.getPatients();
    }
}
