package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-mail")
public class MailTestController {

    private final MailService mailService;

    public MailTestController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping
    public ResponseEntity<String> sendTestMail(){
        try{
            mailService.sendMail("andres.patino@somosf5.org", "Prueba de Escape Room", "Bienvenido al Escape Room!!");
            return ResponseEntity.ok("Correo enviado correctamente");
        } catch (Exception e){

            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al enviar el mail");
        }
    }
}
