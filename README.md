
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
