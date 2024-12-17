package com.escaperoomcoders.escaperoom.service;

import com.escaperoomcoders.escaperoom.model.SecretMessage;
import com.escaperoomcoders.escaperoom.repository.SecretMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretMessageService {

    private final SecretMessageRepository secretMessageRepository;
    private final EscapeRoomMailService escapeRoomMailService;

    public SecretMessageService(SecretMessageRepository secretMessageRepository, EscapeRoomMailService escapeRoomMailService) {
        this.secretMessageRepository = secretMessageRepository;
        this.escapeRoomMailService = escapeRoomMailService;
    }

    public List<SecretMessage> getAllSecretMessages(){
        return secretMessageRepository.findAll();

    }

    public SecretMessage getSecretMessageById(Long id){
        return secretMessageRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Mensaje secreto no encontrado"));
    }

    public SecretMessage createSecretMessage(SecretMessage secretMessage){
        return secretMessageRepository.save(secretMessage);
    }

    public SecretMessage editSecretMessage(Long id, SecretMessage updatedMessage){
        SecretMessage existingMessage = secretMessageRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Mensaje secreto no encontrado con ID: " + id));

        existingMessage.setContent(updatedMessage.getContent());
        existingMessage.setSender(updatedMessage.getSender());

        return secretMessageRepository.save(existingMessage);

    }

    public void deleteMessage(Long id){
        if(!secretMessageRepository.existsById(id)){
            throw new RuntimeException("Mensaje secreto no encontrado");
        }
        secretMessageRepository.deleteById(id);
        escapeRoomMailService.sendMailForChallenge("reto3");
    }

}
