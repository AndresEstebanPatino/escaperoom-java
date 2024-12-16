package com.escaperoomcoders.escaperoom.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;

    public Agent() {
    }

    @ManyToMany(mappedBy = "agents")
    private Set<Mision> misions = new HashSet<>();

    public Agent(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
