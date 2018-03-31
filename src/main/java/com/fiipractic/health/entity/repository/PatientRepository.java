package com.fiipractic.health.entity.repository;


import com.fiipractic.health.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findAllByAge(Long age);
}