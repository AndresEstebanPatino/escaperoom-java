package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.model.SecretMessage;
import com.escaperoomcoders.escaperoom.service.EscapeRoomMailService;
import com.escaperoomcoders.escaperoom.service.MailService;
import com.escaperoomcoders.escaperoom.service.SecretMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secret-message")
public class SecretMessageController {
    private final SecretMessageService secretMessageService;
    private final EscapeRoomMailService escapeRoomMailService;

    public SecretMessageController(SecretMessageService secretMessageService, EscapeRoomMailService escapeRoomMailService) {
        this.secretMessageService = secretMessageService;
        this.escapeRoomMailService = escapeRoomMailService;
    }

    @PostMapping
    public ResponseEntity<SecretMessage> createSecretMessage(@RequestBody SecretMessage secretMessage){
        SecretMessage newSecretMessage = secretMessageService.createSecretMessage(secretMessage);

        return ResponseEntity.ok(newSecretMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecretMessage> getSecretMessageById(Long id){
        SecretMessage messageById = secretMessageService.getSecretMessageById(id);
        return ResponseEntity.ok(messageById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SecretMessage> updateSecretMessage(@PathVariable Long id, @RequestBody SecretMessage updatedMessage) {
        SecretMessage message = secretMessageService.editSecretMessage(id, updatedMessage);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSectretMessage(@PathVariable Long id){

        secretMessageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SecretMessage>> getAllSecretMessages(){
        List<SecretMessage> allSecretsMessages = secretMessageService.getAllSecretMessages();
        escapeRoomMailService.sendMailForChallenge("reto3");
        return ResponseEntity.ok(allSecretsMessages);
    }
}


