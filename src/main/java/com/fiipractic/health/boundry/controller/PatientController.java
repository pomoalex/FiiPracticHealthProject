package com.fiipractic.health.boundry.controller;

import com.fiipractic.health.control.service.EmailService;
import com.fiipractic.health.control.service.PatientService;
import com.fiipractic.health.entity.model.Email;
import com.fiipractic.health.entity.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "patients")
public class PatientController {

    private PatientService patientService;
    private EmailService emailService;

    @Autowired
    public PatientController(PatientService patientService, EmailService emailService) {
        this.patientService = patientService;
        this.emailService = emailService;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Patient savePatient(@RequestBody Patient Patient) {
        return patientService.savePatient(Patient);
    }

    @GetMapping("/filter")
    public List<Patient> getPatientsByAge(@RequestParam("age") Long age) {
        return patientService.findAllPatientsWithAge(age);
    }
}
