package com.fiipractic.health.entity.repository;

import com.fiipractic.health.entity.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
