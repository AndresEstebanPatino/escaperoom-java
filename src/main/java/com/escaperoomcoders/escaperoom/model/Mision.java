package com.escaperoomcoders.escaperoom.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Mision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "agent_mision",
            joinColumns = @JoinColumn(name = "mision_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id")
    )
    private Set<Agent> agents = new HashSet<>();

    public Mision() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
