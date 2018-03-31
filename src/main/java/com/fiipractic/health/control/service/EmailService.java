package com.fiipractic.health.control.service;

import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.entity.model.Email;

import java.util.List;

public interface EmailService {
    List<Email> getEmails();

    Email getEmail(Long id);

    Email saveEmail(Email email);

    Email updateEmail(Email email) throws NotFoundException;

    void deleteEmail(Email email);
}
