package com.escaperoomcoders.escaperoom.repository;

import com.escaperoomcoders.escaperoom.model.SecretMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretMessageRepository extends JpaRepository<SecretMessage, Long> {
}
