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
            case "reto3":
                sendChallenge3completionMail();
                break;
            case "reto4":
                sendChallenge4CompletionMail();
                break;
            case "reto5":
                sendChallenge5CompletionMail();
                break;
            case "reto6":
                sendChallenge6CompletionMail();
                break;
            default:
                throw new IllegalArgumentException("Reto desconocido: " + challenge);
        }
    }

    private void sendChallenge1CompletionMail(){
        if(!GameProgress.isChallengeCompleted("reto1")){
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

    public void sendChallenge3completionMail(){
        if(!GameProgress.isChallengeCompleted("reto3")){
            GameProgress.markChallengeCompleted("reto3");
            String subject = "¡Reto 3 completado!";
            String body = """
                ¡Enhorabuena por completar el reto 3!
                Has dominado la gestión de mensajes secretos en la base de datos.

                Tu siguiente reto es aprender a proteger estos mensajes:
                - Crear en la base de datos a los agentes de tu entera confianza.                
                ¡Prepárate para el reto 4! Recibirás más instrucciones cuando puedas hacer un crud completo, 
                probando por último el método eliminar .
                """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
    private void sendChallenge4CompletionMail() {
        if (!GameProgress.isChallengeCompleted("reto4")) {
            GameProgress.markChallengeCompleted("reto4");
            String subject = "¡Reto 4 completado! Misión cumplida";
            String body = """
            Has preparado el sistema para poder crear agentes de tu confianza, 
            ahora la siguiete misión es crear las misiones, debes crear las misiones
            que quieres que se ejecuten para salvar a la humanidad.
            
            Recibirás noticias cuando hayas terminado el crud de misiones probando por último el método eliminar.
            
            """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
    private void sendChallenge5CompletionMail() {
        if (!GameProgress.isChallengeCompleted("reto5")) {
            GameProgress.markChallengeCompleted("reto5");
            String subject = "¡Reto 5 completado! Misión cumplida";
            String body = """
                Has creado satisfactoriamente las misiones
                tu próxima misión es asignarle una misión a un agente, creando una relación
                de muchos a muchos.
                Recibirás información cuando la completes.
            """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
}
    private void sendChallenge6CompletionMail() {
        if (!GameProgress.isChallengeCompleted("reto6")) {
            GameProgress.markChallengeCompleted("reto6");
            String subject = "¡Reto 6 completado! Misión cumplida";
            String body = """
            ¡Felicidades, agente! 🚀
            Has completado con éxito todas las misiones del Escape Room.

            Logros:
            - Gestionaste mensajes secretos.
            - Asignaste misiones a agentes.
            - Construiste APIs funcionales para manejar archivos clasificados.

            Ahora... un último desafío:
            - Refuerza tu código: revisa y optimiza las entidades y relaciones.
            - Investiga cómo mejorar el rendimiento y la seguridad de tu aplicación.

            ¡Tu entrenamiento ha terminado, agente! La humanidad te lo agradece.
            """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
}
