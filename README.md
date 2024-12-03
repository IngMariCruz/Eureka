# Microservicios con Eureka, Gateway y ConfigServer

Este proyecto consiste en una arquitectura de microservicios utilizando Eureka, un servidor de descubrimiento, y ConfigServer para la gestión de configuraciones. El sistema incluye varios microservicios como Usuario y Curso, con funcionalidades de CRUD y la asignación de alumnos a cursos.

## Componentes del Proyecto

### Microservicios
- **Eureka Server**: Servidor de descubrimiento de servicios. Permite que los microservicios se registren y se descubran entre sí.
- **Usuario**: Microservicio que maneja la gestión de usuarios, proporcionando operaciones CRUD.
- **Curso**: Microservicio que gestiona los cursos y permite realizar operaciones CRUD de los mismos. También permite asignar y eliminar alumnos de los cursos.
- **Gateway**: El API Gateway que gestiona las solicitudes y las redirige a los microservicios correspondientes.
- **ConfigServer**: Servidor centralizado que gestiona todas las configuraciones de los microservicios.

### Librerías Comunes
- **Common**: Contiene clases y utilidades comunes que pueden ser reutilizadas en varios microservicios.
- **CommonsService**: Servicio que incluye funcionalidades comunes para los otros microservicios, además de las entidades curso y alumno.

## Requisitos
- Java 11 o superior
- Maven 3.8.x o superior
