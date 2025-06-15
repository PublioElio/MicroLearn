<p align="center">
  <img src="https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExYW5uYzR2dmQ2YmVjdHViZjlnaGg5YmR3N2V4Z2p6cDVmcHVwdzQybiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/ZN4J5o5nvjzaxF2X64/giphy.gif" alt="MicroLearn Banner" width="200">
</p>

# MicroLearn - Course Management API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)
![JPA](https://img.shields.io/badge/Spring%20Data%20JPA-Enabled-orange)
![REST](https://img.shields.io/badge/API-RESTful-red)
![Build](https://img.shields.io/badge/Build-Maven-yellow)
![Serialization](https://img.shields.io/badge/Serialization-JSON%20%2F%20XML-lightgrey)
![Tests](https://img.shields.io/badge/Tested-JUnit%205%20%2F%20MockMvc-success)
![License](https://img.shields.io/badge/License-MIT-informational)

## 📚 Descripción
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

## 🎓 Instalación y configuración 

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

## 👩‍🎓 Modelo de datos 
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
