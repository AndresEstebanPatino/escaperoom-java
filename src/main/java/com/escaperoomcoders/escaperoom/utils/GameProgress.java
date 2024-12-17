package com.escaperoomcoders.escaperoom.utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GameProgress {

    private static final String PROGRESS_FILE = System.getProperty("user.home") + "/game-progress.txt";

    public static boolean isChallengeCompleted(String challenge){
        Properties properties = loadProperties();
        String value = properties.getProperty(challenge, "false");
        System.out.println("Estado del reto " + challenge + ": " + value);
        return "true".equalsIgnoreCase(value);
    }

    public static void markChallengeCompleted(String challenge){
        try {
            Properties properties = loadProperties();
            properties.setProperty(challenge, "true"); // Marca el reto como completado
            saveProperties(properties); // Guarda los cambios en el archivo
            System.out.println("Progreso guardado para: " + challenge);
        } catch (Exception e){
            System.err.println("Error al guardar el progreso: " + e.getMessage());
        }
    }

    private static Properties loadProperties(){
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(PROGRESS_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Archivo de progreso no encontrado. Se creará uno nuevo.");
        }
        return properties;
    }

    private static void saveProperties(Properties properties){
        try (FileOutputStream output = new FileOutputStream(PROGRESS_FILE)) {
            properties.store(output, "Progreso del Escape Room");
            System.out.println("Progreso guardado en: " + new java.io.File(PROGRESS_FILE).getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar el archivo de progreso: " + e.getMessage());
        }
    }
    public static void resetProgress() {
        try (FileOutputStream output = new FileOutputStream(PROGRESS_FILE)) {
            Properties properties = new Properties();
            properties.store(output, "Reiniciar progreso del juego");
            System.out.println("Progreso reiniciado: todos los retos están incompletos.");
        } catch (IOException e) {
            System.err.println("Error al reiniciar el progreso: " + e.getMessage());
        }
    }

}
