# EntrevistaTecnica

Solución al Challenge ​Entrevista Técnica con Backend (Java)

## Empezando

Estas instrucciones le proporcionarán una copia del proyecto en su máquina local con fines de desarrollo y prueba. Consulte la implementación para obtener informacón sobre cómo implementar el proyecto.

### Prerequisitos

- IDE : IntelliJ IDEA o Eclipse
- Terminal
- Navegador web
- Maven
- Java 11
- MySql
- MySQL Workbench

### Estructura del proyecto

#### Backend (Java)
Patron MVC (Modelo - Vista - Controlador)
Cada capa tiene una responsabilidad particular y cada paquete del proyecto agrupa clases comunes: 
- controllers: reciben y tratan los request http.
- services: lógica de negocio.
- entidades: los modelos que representan el negocio.
- dto: clase de objetos que se devuelven a la vista
- exceptions: excepciones para el manejo de errores.

### Instalación y ejecución

1. Importar el proyecto al IDE como "Existing Maven Projects"

2. Abrir Workbench e iniciar el motor de base de datos.

3. Crear base de datos con el siguiente comando "create schema cashonlinedb;" 

4. Ejecutar desde la terminal en el raiz del proyecto: mvn install

5. Desde el IDE correr la aplicación con "Run - Run As - Spring Boot App"

6. Una vez arrancada la aplicación en el archivo "applications properties" cambiar de "spring.jpa.hibernate.ddl-auto = create" a "spring.jpa.hibernate.ddl-auto = none"  

7. Cargar datos para la base de datos desde Workbench para realizar las pruebas (script entregado en la carpeta resources del proyecto "cashOnline.sql")

8. Abrir Postman y realizar las pruebas pertinentes 

9. Disfrute la aplicación


## Autor

* **Damián Marasco - marascodamian** 
 

