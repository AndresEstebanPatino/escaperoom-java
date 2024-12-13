package com.escaperoomcoders.escaperoom.utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GameProgress {

    private static final String PROGRESS_FILE = "game-progress.txt";

    public static boolean isChallengeCompleted(String challenge){
        Properties properties = loadProperties();
        return "true".equalsIgnoreCase(properties.getProperty(challenge, "false"));
    }

    public static void markChallengeCompleted(String challenge){
        try {

            Properties properties = loadProperties();
            properties.setProperty(challenge, "true");

            saveProperties(properties);

        } catch (Exception e){
            System.out.println("Error al enviar mensaje " + e.getMessage());
            throw new RuntimeException("Error al guardar el progreso");
        }

    }

    public static Properties loadProperties(){
        Properties properties = new Properties();
        try(FileInputStream input = new FileInputStream(PROGRESS_FILE)){
             properties.load(input);
        }catch (IOException e){
            //Archivo no existe aún
        }
        return properties;
    }

    private static void saveProperties(Properties properties){
        try(FileOutputStream output = new FileOutputStream(PROGRESS_FILE)) {
             properties.store(output, "progreso del Escape Room");
        }    catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
