package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.service.EscapeRoomMailService;
import com.escaperoomcoders.escaperoom.service.MailService;
import com.escaperoomcoders.escaperoom.utils.GameProgress;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-email")

public class MailTestController {

    private final EscapeRoomMailService escapeRoomMailService;

    public MailTestController(EscapeRoomMailService escapeRoomMailService) {
        this.escapeRoomMailService = escapeRoomMailService;
    }

    @GetMapping
    public ResponseEntity<String> sendTestMail(){
        try{
            escapeRoomMailService.sendMailForChallenge("reto1");

            return ResponseEntity.ok("Correo enviado con éxito. Reto 1 completado. Pistas del reto 2 enviadas");
        } catch (Exception e){

            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al enviar correo " + e.getMessage());
        }
    }
}
