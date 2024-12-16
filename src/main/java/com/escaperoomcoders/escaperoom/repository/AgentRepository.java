package com.escaperoomcoders.escaperoom.repository;

import com.escaperoomcoders.escaperoom.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
