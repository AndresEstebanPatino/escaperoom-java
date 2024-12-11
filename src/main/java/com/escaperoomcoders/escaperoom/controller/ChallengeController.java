package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.model.User;
import com.escaperoomcoders.escaperoom.repository.UserRepository;
import com.escaperoomcoders.escaperoom.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/challenged")
public class ChallengeController {

    private MailService mailService;
    private final UserRepository userRepository;


    public ChallengeController(MailService mailService, UserRepository userRepository) {
        this.mailService = mailService;
        this.userRepository = userRepository;
    }

    @PostMapping("/setup-email")
    public ResponseEntity<String> setupEmail(@RequestParam String email){
        User user = new User();
        user.setEmail(email);
        userRepository.save(user);

        mailService.sendMail(email, "Reto 1 completado", "Has configurado tu correo, revisa tu bandeja de entrada");
        return ResponseEntity.ok("Correo configurado con éxito. Revisa tu bandeja de entrada");
    }

    @PostMapping("/challenge2")
    public ResponseEntity<String> completeChallenge2(@RequestParam String email){
        Optional<User> user =userRepository.findByEmail(email);

        if(user.isPresent() && !user.get().isChallenged1Complete()){
            return ResponseEntity.badRequest().body("Completa el reto 1 primero");
        }

        User existingUSer = user.get();
        existingUSer.setChallenged1Complete(true);
        userRepository.save(existingUSer);

        mailService.sendMail(email, "Reto completado", "conexión exitosa");
        return ResponseEntity.ok("Reto completado");
    }
}
