package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.service.EscapeRoomMailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
@RequestMapping("/test-database")
public class DataBaseTestController {

    private final DataSource dataSource;
    private final EscapeRoomMailService escapeRoomMailService;

    public DataBaseTestController(DataSource dataSource, EscapeRoomMailService escapeRoomMailService) {
        this.dataSource = dataSource;
        this.escapeRoomMailService = escapeRoomMailService;
    }

    @GetMapping

    public ResponseEntity<String> testDatabaseConnection(){
        try(Connection connection = dataSource.getConnection()) {
            escapeRoomMailService.sendMailForChallenge("reto2");
            System.out.println(dataSource);

            return ResponseEntity.ok("Conexión a la base de datos exitosa, reto 2 completado.");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al conectar con la base de datos");
        }
    }
}
