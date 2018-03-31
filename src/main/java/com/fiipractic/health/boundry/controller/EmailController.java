package com.fiipractic.health.boundry.controller;

import com.fiipractic.health.boundry.exceptions.BadRequestException;
import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.boundry.mapper.ObjectMapper;
import com.fiipractic.health.control.service.EmailService;
import com.fiipractic.health.entity.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "emails")
public class EmailController {
    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public List<Email> getEmails() {
        return emailService.getEmails();
    }

    @GetMapping(value = "/{id}")
    public Email getEmail(@PathVariable("id") Long id) throws NotFoundException {
        Email email = emailService.getEmail(id);
        if (email == null) {
            throw new NotFoundException(String.format("Email with id=%s was not found.", id));
        }
        return email;
    }

    @PutMapping(value = "/{id}")
    public Email updateEmail(@PathVariable("id") Long id, @RequestBody Email email) throws BadRequestException, NotFoundException {
        //validate request
        if (!id.equals(email.getId())) {
            throw new BadRequestException("The id is not the same with id from object");
        }
        Email emailDb = emailService.getEmail(id);
        if (emailDb == null) {
            throw new NotFoundException(String.format("Email with id=%s was not found.", id));
        }
        ObjectMapper.map2EmailDb(emailDb, email);
        return emailService.updateEmail(emailDb);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Email saveEmail(@RequestBody Email email) {
        return emailService.saveEmail(email);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmail(@PathVariable Long id) throws NotFoundException {
        Email emailDb = emailService.getEmail(id);
        if (emailDb == null) {
            throw new NotFoundException(String.format("Email with id=%s was not found.", id));
        }
        emailService.deleteEmail(emailDb);
    }
}
