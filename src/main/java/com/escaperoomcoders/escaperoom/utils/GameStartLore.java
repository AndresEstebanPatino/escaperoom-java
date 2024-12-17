package com.escaperoomcoders.escaperoom.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameStartLore implements CommandLineRunner {

    @Override
    public void run(String... args){
        if (!GameProgress.isChallengeCompleted("reto 1")){
            System.out.println("********************************************************");
            System.out.println("*                                                      *");
            System.out.println("*          🚨 BIENVENIDO AL ESCAPE ROOM:               *");
            System.out.println("*              MISIÓN: RESCATE DIGITAL                 *");
            System.out.println("*                                                      *");
            System.out.println("*  El mundo está en peligro. Una red secreta ha sido   *");
            System.out.println("*  desactivada y nuestros sistemas están colapsando.   *");
            System.out.println("*                                                      *");
            System.out.println("*  🔐 PRIMER RETO: ESTABLECER EL SERVICIO DE CORREO    *");
            System.out.println("*                                                      *");
            System.out.println("*  Objetivo: Configura el servicio SMTP y envía un     *");
            System.out.println("*  mensaje de prueba a la Central de Operaciones.      *");
            System.out.println("*  recuerda configurar las variables de entorno.       *");
            System.out.println("*  recuerda crear una aplicación en .                  *");
            System.out.println("*                                                      *");
            System.out.println("*  📌 Pistas:                                          *");
            System.out.println("*  - Servidor SMTP: smtp.gmail.com                     *");
            System.out.println("*  - Puerto seguro: 587                                *");
            System.out.println("*  - Archivo: application.properties                   *");
            System.out.println("*  - Endpoint para verificar la conexión:              *");
            System.out.println("*    `http://localhost:8080/test-database`             *");
            System.out.println("*                                                      *");
            System.out.println("*  La comunicación es crítica. ¡Sin correo no hay      *");
            System.out.println("*  misiones! La humanidad cuenta contigo, agente.      *");
            System.out.println("*                                                      *");
            System.out.println("*******************************************************");

        }

    }
}
