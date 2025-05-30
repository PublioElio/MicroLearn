<p align="center">
  <img src="https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExYW5uYzR2dmQ2YmVjdHViZjlnaGg5YmR3N2V4Z2p6cDVmcHVwdzQybiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/ZN4J5o5nvjzaxF2X64/giphy.gif" alt="MicroLearn Banner">
</p>

# MicroLearn - Course Management API  

## 📌 Descripción
MicroLearn es una **API REST** desarrollada con **Spring Boot** y **Spring Data JPA**, que permite gestionar cursos. Ofrece funcionalidades para **listar, buscar, añadir, actualizar y eliminar cursos** mediante endpoints bien definidos.  

## 🔧 Tecnologías utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**  
- **Jackson para serialización XML/JSON**  
- **JUnit 5 y MockMvc para pruebas**  

## 📂 Estructura del proyecto  
```
microlearn/
│── src/
│   ├── main/java/com/microlearn
│   │   ├── controllers/      # Controladores REST
│   │   ├── model/            # Modelos de datos
│   │   ├── MicroLearnApplication.java  # Clase principal
│   ├── test/java/com/microlearn
│   │   ├── MicroLearnApplicationTests.java  # Pruebas unitarias
│── resources/
│   ├── application.properties  # Configuración de la aplicación
│── pom.xml  # Dependencias de Maven
```

## 🚀 Instalación y configuración 

### 1️⃣ Prerrequisitos
Antes de ejecutar la aplicación, asegúrate de tener instalado:  
- **Java 17 o superior**  
- **Maven** (si utilizas Maven)  
- **Gradle** (si usas Gradle como alternativa)  

### 2️⃣ Clonar el repositorio 
```
git clone https://github.com/tuusuario/microlearn.git
cd microlearn
```
### 3️⃣ Configuración de propiedades 
El archivo `application.properties` define las configuraciones clave:  
```
spring.application.name=MicroLearn
server.port=4200
```
Esto establece el nombre de la aplicación y el puerto en el que se ejecutará (**4200** en lugar del **8080** por defecto).  

### 4️⃣ Compilar el proyecto  
Si usas **Maven**:  
```
mvn clean package
```  
Si usas **Gradle**:  
```
./gradlew build
```

### 5️⃣ Ejecutar la aplicación  
```
mvn spring-boot:run
```
o  
```
java -jar target/microlearn-0.0.1-SNAPSHOT.jar
```

## 🌍 Endpoints disponibles  
### CoursesController - Gestión de cursos  
| Método | Endpoint | Descripción | Tipo de respuesta |
|--------|---------|------------|-------------------|
| `GET` | `/courses` | Obtiene todos los cursos disponibles | XML |
| `GET` | `/courses/{title}` | Busca cursos por título | JSON |
| `GET` | `/courses/course` | Devuelve un curso predefinido | XML |
| `POST` | `/courses` | Agrega un nuevo curso | JSON |
| `PUT` | `/courses/{title}` | Actualiza un curso por título | JSON |
| `DELETE` | `/courses/{title}` | Elimina un curso por título | JSON |

## 🏗 Modelo de datos 
### Course 
La entidad `Course` representa un curso en el sistema.  
```
@JacksonXmlRootElement
public class Course {
    private String title;
    private int length;
    private String schedule;
}
```

#### Ejemplo JSON  
```
{
  "title": "Spring Boot",
  "length": 150,
  "schedule": "Afternoon"
}
```

#### Ejemplo XML  
```xml
<Course>
  <title>Spring Boot</title>
  <length>150</length>
  <schedule>Afternoon</schedule>
</Course>
```

## 🧪 Pruebas  
### MicroLearnApplicationTests 
La aplicación cuenta con una suite de pruebas unitarias e integración para validar el correcto funcionamiento de los endpoints.  

### Ejecutar pruebas:  
```sh
mvn test
```
o  
```sh
./gradlew test
```

### Casos de prueba en `MicroLearnApplicationTests`  
| Test | Método | Endpoint | Esperado |
|------|--------|----------|-----------|
| `deleteCourse()` | `DELETE` | `/courses/Python` | 200 OK (Curso eliminado) |
| `testCourses()` | `GET` | `/courses` | 200 OK (Lista de cursos) |
| `createCourse()` | `POST` | `/courses` | 201 Created (Curso agregado) |
| `updateCourse()` | `PUT` | `/courses/Angular 10` | 200 OK (Curso actualizado) |

## 🎯 Conclusión  
MicroLearn proporciona una API REST ligera y estructurada para la gestión de cursos. Con soporte para **JSON y XML**, validaciones y pruebas automatizadas, es una excelente base para proyectos educativos o plataformas de aprendizaje.  

📌 **¿Qué sigue?**  
Si deseas mejorar esta aplicación, puedes:  
- Integrar **Spring Data JPA con una base de datos real** (PostgreSQL, MySQL, etc.).  
- Implementar **Swagger** para la documentación de API.  
- Crear un cliente frontend con **Angular, React o Vue**.  
