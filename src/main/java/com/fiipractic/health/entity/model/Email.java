package com.fiipractic.health.entity.model;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100)
    private String email;

    @OneToOne(mappedBy = "email")
    private Doctor doctor;

    @OneToOne(mappedBy = "email")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
