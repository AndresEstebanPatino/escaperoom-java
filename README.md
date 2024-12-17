
# Escape Room: Rescate Digital

## Descripción del Proyecto
**Escape Room: Rescate Digital** es una aventura de desarrollo backend diseñada para desafiar a los participantes a resolver retos incrementales mientras aprenden a gestionar servicios, bases de datos y relaciones entre entidades. Los jugadores actuarán como **hackers de una organización secreta** que buscan salvar al mundo restableciendo un sistema crítico.

## Historia
La humanidad está al borde del colapso digital. La red mundial de comunicaciones y sistemas ha sido comprometida, y solo los mejores desarrolladores pueden reconstruirla. Tú, agente de confianza, tienes la misión de restaurar los sistemas clave. Cada reto desbloqueará una parte crítica del sistema hasta completar el rescate digital. 

### Progresión de Misiones:
1. **Reto 1:** Configura el servicio de correo para restablecer las comunicaciones.
2. **Reto 2:** Conéctate a la base de datos para recuperar los archivos perdidos.
3. **Reto 3:** Implementa un CRUD para gestionar mensajes secretos.
4. **Reto 4:** Crea un sistema para gestionar agentes de confianza.
5. **Reto 5:** Diseña y administra misiones críticas.
6. **Reto 6:** Asigna agentes a las misiones mediante una relación de muchos a muchos.

---

## Tecnologías Utilizadas
- **Java 20**
- **Spring Boot 3.4.0**
- **MySQL** (con Workbench para gestión)
- **Postman** (para probar endpoints)
- **JavaMailSender** (para envío de correos)
- **Maven** (gestión de dependencias)

---

## Configuración del Proyecto

### Prerrequisitos
1. **Java JDK 20** instalado.
2. **MySQL Server** corriendo en el puerto `3306`.
3. **IntelliJ IDEA** u otro IDE compatible.
4. **Postman** para probar los endpoints.
5. Una cuenta de correo habilitada con contraseña de aplicación (para el servicio de mailing).
---

### Variables de Entorno
Configura las siguientes variables en el archivo `application.properties` o usando variables de entorno:
```properties
# Configuración del correo
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL@gmail.com
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/escaperoom
spring.datasource.username=root
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Configuración del sistema de progreso
game-progress.file=game-progress.txt
```
---

### Configuración del Servicio de Envío de Correos

Para que el sistema pueda enviar correos electrónicos usando **Gmail**, sigue estos pasos:

#### 1. Activar la Verificación en Dos Pasos

1.  Accede a tu cuenta de **Gmail**.
2.  Dirígete a **Configuración de Seguridad** en Mi cuenta de Google.
3.  En la sección **Iniciar sesión en Google**, activa la **Verificación en dos pasos**.

#### 2. Generar una Contraseña de Aplicación

Como Gmail requiere seguridad adicional para acceder desde aplicaciones externas, necesitas una **contraseña específica para aplicaciones**:

1.  En la sección **Verificación en dos pasos**, busca la opción **Contraseñas de aplicaciones**.
2.  Selecciona **Correo** en el primer desplegable y **Otro (nombre personalizado)** en el segundo.
3.  Escribe un nombre para identificar tu aplicación (por ejemplo: `escape-room-backend`).
4.  Genera la contraseña y copia el código (sin espacios). **Guárdalo en un lugar seguro.**

#### 3. Configurar las Variables de Entorno en `application.properties`

Añade tu cuenta de Gmail y la contraseña de aplicación al archivo de configuración:

```properties

Copiar código

`# Configuración del correo
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL@gmail.com
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.debug=true`

```

-   **`YOUR_EMAIL@gmail.com`**: Reemplázalo por tu dirección de correo de Gmail.
-   **`YOUR_APP_PASSWORD`**: Reemplázalo por la contraseña de aplicación que generaste.

#### 4. Probar el Servicio de Correo

Para verificar que todo está configurado correctamente, ejecuta el proyecto y accede al siguiente endpoint:

```bash

Copiar código

`GET http://localhost:8080/test-email` 

```
Si todo está bien configurado, recibirás un correo de prueba con las instrucciones para el **Reto 1**.

---

### Configurar MySQL
1. Crea la base de datos `escaperoom` en **MySQL Workbench**:
   ```sql
   CREATE DATABASE escaperoom;
   ```
2. Asegúrate de que el usuario `root` tiene los permisos correctos.

---

## Ejecución del Proyecto

### Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/escape-room.git
cd escape-room
```

### Compilar y Ejecutar
```bash
mvn clean install
mvn spring-boot:run
```

### Probar los Endpoints
| Reto | Endpoint                           | Método | Descripción                              |
|------|------------------------------------|--------|------------------------------------------|
| 1    | `/test-email`                      | GET    | Test del envío de correo.                |
| 2    | `/test-database`                   | GET    | Test de la conexión a la base de datos.  |
| 3    | `/api/secret-message`              | CRUD   | Gestión de mensajes secretos.            |
| 4    | `/api/agents`                      | CRUD   | Gestión de agentes.                      |
| 5    | `/api/missions`                    | CRUD   | Gestión de misiones.                     |
| 6    | `/api/missions/{id}/assign-agent`  | PUT    | Asignar un agente a una misión.          |

---

## Progreso del Juego
El sistema utiliza un archivo `game-progress.txt` para registrar los retos completados. Cada vez que completes un reto, se marcará en este archivo.

Ejemplo de progreso:
```text
#progreso del Escape Room
reto1=true
reto2=true
reto3=false
```

---

## Estructura del Proyecto
```
escaperoom/
│-- src/
│   ├── main/
│   │   ├── java/com/escaperoomcoders/escaperoom/
│   │   │   ├── controller/         # Controladores REST
│   │   │   ├── model/              # Modelos de entidades
│   │   │   ├── repository/         # Repositorios JPA
│   │   │   ├── service/            # Lógica de negocio
│   │   │   └── utils/              # Utilidades (GameProgress)
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── game-progress.txt
│   ├── test/                       # Pruebas unitarias
└── pom.xml                         # Dependencias Maven
```
---
## Repositorio inciial 
El reto inicial está en el siguiente repositorio:
**Repositorio de la Solución**([https://github.com/AndresEstebanPatino/escaperoom-java-solution](https://github.com/AndresEstebanPatino/escaperoom-java-solution))
---
---

## Créditos
Este proyecto fue desarrollado como parte de un apoyo pedagógico a un **bootcamp backend** para enseñar habilidades de desarrollo en Java y Spring Boot de manera práctica e interactiva.

Desarrollado por: **Andrés Esteban Patiño Gómez**

---

## Contacto
Si tienes preguntas o sugerencias sobre este proyecto, no dudes en contactarnos:
- **Email:** andresp199519@gmail.com
- **GitHub:** [AndresEstebanPatino](https://github.com/AndresEstebanPatino)

---

¡Buena suerte, agente! La humanidad cuenta contigo. 🚀
