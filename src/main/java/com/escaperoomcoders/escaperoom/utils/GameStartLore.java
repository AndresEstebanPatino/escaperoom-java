package com.escaperoomcoders.escaperoom.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameStartLore implements CommandLineRunner {

    @Override
    public void run(String... args){
        if (!GameProgress.isChallengeCompleted("reto 1")){
            System.out.println("******************************************************");
            System.out.println("*                                                    *");
            System.out.println("*  Bienvenido al ESCAPE ROOM: Rescate Digital        *");
            System.out.println("*                                                    *");
            System.out.println("*  El sistema ha sufrido un colapso catastrófico.    *");
            System.out.println("*  Los servicios críticos han sido deshabilitados.   *");
            System.out.println("*                                                    *");
            System.out.println("*  Primer reto: Establecer el servicio de correo     *");
            System.out.println("*  para habilitar las comunicaciones.                *");
            System.out.println("*                                                    *");
            System.out.println("*  Usa tus habilidades para solucionar este problema.*");
            System.out.println("*  La humanidad cuenta contigo.                      *");
            System.out.println("******************************************************");
        }

    }
}
