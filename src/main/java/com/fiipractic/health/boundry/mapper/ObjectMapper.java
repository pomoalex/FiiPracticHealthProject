package com.fiipractic.health.boundry.mapper;

import com.fiipractic.health.entity.model.Doctor;
import com.fiipractic.health.entity.model.Email;
import com.fiipractic.health.entity.model.Patient;

public class ObjectMapper {

    public static void map2DoctorDb(Doctor doctorDb, Doctor doctorRequest) {
        doctorDb.setName(doctorRequest.getName());
        doctorDb.setFunction(doctorRequest.getFunction());
        doctorDb.setEmail(doctorRequest.getEmail());
    }

    public static void map2PatientDb(Patient patientDb, Patient patientRequest) {
        patientDb.setName(patientRequest.getName());
        patientDb.setAge(patientRequest.getAge());
        patientDb.setEmail(patientRequest.getEmail());
    }

    public static void map2EmailDb(Email emailDB, Email emailRequest) {
        emailDB.setEmail(emailRequest.getEmail());
    }
}
