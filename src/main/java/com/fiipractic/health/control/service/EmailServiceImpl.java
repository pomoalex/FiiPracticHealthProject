package com.fiipractic.health.control.service;

import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.entity.model.Email;
import com.fiipractic.health.entity.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

    @Override
    public Email getEmail(Long id) {
        Optional<Email> optionalDoctor = emailRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    @Override
    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public Email updateEmail(Email email) throws NotFoundException {
        if (email.getId() != null) {
            return emailRepository.save(email);
        }
        throw new NotFoundException("No such email found");
    }

    @Override
    public void deleteEmail(Email email) {
        emailRepository.delete(email);
    }
}
