package com.fiipractic.health.service;

import com.fiipractic.health.model.Doctor;

import java.util.List;


public interface DoctorService {
    Doctor getDoctor(Long id);

    Doctor saveDoctor(Doctor doctor);

    List<Doctor> getDoctors();
}
