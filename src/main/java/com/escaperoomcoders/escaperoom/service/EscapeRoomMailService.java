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
            String subject = "¡Reto 1 completado!";
            String body = """  
                            Agente,
                            

                            Excelente trabajo asegurando la comunicación. Ahora necesitamos acceso a la **base de datos secreta** para desbloquear información clasificada.

                            💻 **Objetivo**: \s
                            Conéctate a la base de datos MySQL y verifica la conexión con el sistema.

                            **Pistas**: \s
                            1. Confirma que el servidor MySQL está activo (puerto 3306). \s
                            2. Configura los parámetros en **application.properties** (url, username, password). \s
                            3. Prueba tu conexión en el endpoint: \s
                            `http://localhost:8080/test-database`

                            **Acceder a esta información es clave** para detener a la corporación. No falles.

                            - Central de Operaciones

                                                
                    """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }

    private void sendChallenge2CompletionMail(){
        if (!GameProgress.isChallengeCompleted("reto2")){
            GameProgress.markChallengeCompleted("reto2");
            String subject = "¡Reto 2 completado!";
            String body = """  
                    Agente,
                                
                                Tu acceso a la base de datos ha sido confirmado. Ahora debes implementar una API para **gestionar los mensajes secretos interceptados**.
                                
                                💾 **Objetivo**: \s
                                Crea un sistema que permita realizar las siguientes operaciones: \s
                                1. **Crear mensajes** con el contenido interceptado. \s
                                2. **Editar mensajes existentes**. \s
                                3. **Eliminar mensajes no relevantes**. \s
                                4. **Ver todos los mensajes registrados**.
                                
                                **Pistas**:
                                1. Modelo del mensaje: \s
                                   - `content`: El contenido del mensaje interceptado. \s
                                   - `sender`: El nombre del agente que envía el mensaje. \s
                                2. Implementa un CRUD básico en la API. \s
                                3. Endpoint sugerido: `/api/secret-message`
                                
                                Cada mensaje es una pista hacia la verdad. No pierdas ni uno solo.
                                
                                - Central de Operaciones
                                
                    """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }

    }

    public void sendChallenge3completionMail(){
        if(!GameProgress.isChallengeCompleted("reto3")){
            GameProgress.markChallengeCompleted("reto3");
            String subject = "¡Reto 3 completado!";
            String body = """
                                    Agente,
                                                
                                    Es hora de **reclutar a los agentes más confiables**. Debes implementar un sistema para registrar, actualizar y eliminar agentes.
                                                
                                    🔐 **Objetivo**: \s
                                    Crea una API que permita: \s
                                    - **Registrar agentes** con sus nombres y roles. \s
                                    - **Actualizar la información** de un agente. \s
                                    - **Eliminar agentes** no autorizados.
                                                
                                    **Pistas**:
                                    1. Modelo del agente: \s
                                       - `name`: Nombre del agente. \s
                                       - `role`: Rol asignado (ejemplo: "Analista", "Infiltrado"). \s
                                    2. Endpoint sugerido: `/api/agents` \s
                                    3. Verifica que el sistema responde a las operaciones CRUD.
                                                
                                    Tu equipo debe estar listo para las misiones futuras. Confía, pero verifica.
                                                
                                    - Central de Operaciones
                    """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
    private void sendChallenge4CompletionMail() {
        if (!GameProgress.isChallengeCompleted("reto4")) {
            GameProgress.markChallengeCompleted("reto4");
            String subject = "¡Reto 4 completado! Misión cumplida";
            String body = """
                            Agente,
                                      
                            Nuestro equipo está listo. Ahora debes crear las **misiones** que ejecutarán los agentes.
                                                    
                            📋 **Objetivo**: \s
                            Crea una API para gestionar las misiones: \s
                            - **Registrar misiones** con nombre y descripción. \s
                            - **Actualizar detalles** de las misiones. \s
                            - **Eliminar misiones** completadas.
                                                    
                            **Pistas**:
                            1. Modelo de misión: \s
                               - `title`: Nombre de la misión. \s
                               - `description`: Breve descripción del objetivo. \s
                            2. Endpoint sugerido: `/api/missions` \s
                            3. Prueba las operaciones CRUD para confirmar que funcionan.
                                                   
                            Cada misión nos acerca más a desmantelar la corporación. El éxito depende de ti.
                                                    
                            - Central de Operaciones
                                
                    """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
    private void sendChallenge5CompletionMail() {
        if (!GameProgress.isChallengeCompleted("reto5")) {
            GameProgress.markChallengeCompleted("reto5");
            String subject = "¡Reto 5 completado! Misión cumplida";
            String body = """
                    Agente,
                                        
                    Este es el último paso. **Asigna las misiones a los agentes** de tu equipo y coordina la operación final.
                                        
                    🚀 **Objetivo**: \s
                    1. Implementa la asignación de misiones a los agentes con una relación **muchos a muchos**. \s
                    2. Endpoint para asignar misiones: `/api/missions/{missionId}/assign-agent/{agentId}` \s
                    3. Confirma que un agente pueda tener varias misiones y viceversa.
                                        
                    **Pistas**: \s
                    - Actualiza las relaciones en ambas entidades (Misión y Agente). \s
                    - Verifica que la asignación no duplique entradas. \s
                    - La operación debe reflejarse en la base de datos.
                                        
                    La humanidad está al borde del abismo, pero tú y tu equipo pueden salvarla. **Este es tu momento**.
                                        
                    - Central de Operaciones
                                        
                    """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
}
    private void sendChallenge6CompletionMail() {
        if (!GameProgress.isChallengeCompleted("reto6")) {
            GameProgress.markChallengeCompleted("reto6");
            String subject = "¡Reto 6 completado! Misión cumplida";
            String body = """
                    ¡Enhorabuena, agente! 🎉 \s
                    Has completado todas las misiones del Escape Room: Rescate Digital. \s

                    Logros alcanzados:
                    - Configuraste el servicio de correo. \s
                    - Conectaste la base de datos. \s
                    - Gestionaste mensajes secretos y agentes. \s
                    - Definiste y asignaste misiones críticas. \s

                    🌍 Gracias a tu esfuerzo, hemos restablecido la red y asegurado el futuro de la humanidad. \s
                    La Central de Operaciones te felicita por tu valentía y destreza. \s

                    ¡Misión cumplida! 🚀 \s

                                        """;

            mailService.sendMail("andres.patino@somosf5.org", subject, body);
        }
    }
}
