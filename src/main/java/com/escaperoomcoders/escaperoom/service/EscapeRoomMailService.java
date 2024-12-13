package com.escaperoomcoders.escaperoom.service;

import com.escaperoomcoders.escaperoom.utils.GameProgress;
import org.springframework.stereotype.Service;

@Service
public class EscapeRoomMailService {

    private final MailService mailService;

    public EscapeRoomMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void sendMailForChallenge(String challenge){
        switch (challenge){
            case "reto1":
                sendChallenge1CompletionMail();
                break;
            case "reto2":
                sendChallenge2CompletionMail();
                break;
            default:
                throw new IllegalArgumentException("Reto desconocido: " + challenge);
        }
    }

    private void sendChallenge1CompletionMail(){
        if(GameProgress.isChallengeCompleted("reto1")){
            GameProgress.markChallengeCompleted("reto1");
            String subject = "Instrucciones para el reto 2";
            String body = """  
            ¡Felicidades por completar el reto 1!
            Tu próxima misión: conectar la aplicación a la base de datos.
            Pistas:
            - Asegúrate de que Mysql esté corriendo en tu sistema.
            - Prueba conectarte al puerto 3306
            - configura los detalles de conexión deñ archivo application.properties
              - url
              - username
              - contraseña
            Una vez que la conexión estñe configurada, accede al endpoint para vertificar:
            http://localhost:8080/test-database
                    
            """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }

    private void sendChallenge2CompletionMail(){
        if (!GameProgress.isChallengeCompleted("reto2")){
            GameProgress.markChallengeCompleted("reto2");
            String subject = "Instrucciones para el reto 3";
            String body = """  
                    ¡Felicidades por completar el reto 2!
                    Has logrado acceder al sistema de archivos clasificados. Ahora...
                    Tu próxima misión es: Construir una API que permita gestionar estos archivos. 
                    Tu trabajo será vital para que la operación de espionaje continúe de forma eficiente.
                                
                            #### Objetivo
                            Implementa los siguientes endpoints para la entidad `ClassifiedFile`:
                            1. **GET /files** - Obtener una lista de todos los archivos clasificados.
                            2. **POST /files** - Registrar un nuevo archivo clasificado.
                            3. **PUT /files/{id}** - Actualizar un archivo existente.
                            4. **DELETE /files/{id}** - Eliminar un archivo desactualizado.
                                        
                            #### Detalles de la Entidad
                            Cada archivo clasificado debe contener la siguiente información:
                            - **id** (Long): Identificador único del archivo.
                            - **title** (String): Título del archivo.
                            - **content** (String): Contenido del archivo clasificado (máximo 500 caracteres).
                            - **level** (String): Nivel de clasificación del archivo (`"Top Secret"`, `"Confidential"`, `"Restricted"`).
                            - **agent** (String): Nombre del agente responsable del archivo.
                                        
                            #### Pistas
                            1. **Modelo:**
                               Define una clase `ClassifiedFile` con las propiedades mencionadas anteriormente.
                               ```java
                               @Entity
                               public class ClassifiedFile {
                                   @Id
                                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                                   private Long id;
                                   private String title;
                                   private String content;
                                   private String level;
                                   private String agent;
                                        
                                   // Getters y Setters
                               }
                    """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
}
