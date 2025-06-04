# 🧶 Backend - Amigurimis Atelier

Este proyecto consiste en el desarrollo del backend de una aplicación web para gestionar productos, pedidos y usuarios en una tienda de amigurumis (tejidos a crochet), utilizando **Java + Spring Boot**.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.5.0**
- **Maven**
- **MySQL**
- **Postman** (para pruebas de API)
- **JPA/Hibernate** (persistencia)
- **Lombok** *(opcional si está configurado)*

## 📁 Estructura del proyecto

El backend incluye lo siguiente:

- `model/`: contiene las entidades como `Usuario`, `Producto`, `Pedido`, `DetallePedido`, `Carrito`, etc.
- `repository/`: interfaces JPA para interactuar con la base de datos.
- `controller/`: se agregará para exponer los endpoints REST.
- `application.properties`: configuración de la conexión a MySQL.

## 🛠️ ¿Qué hicimos?

- Montamos la estructura base del proyecto con Spring Boot.
- Creamos las entidades principales con sus relaciones (`@ManyToOne`, `@OneToMany`).
- Configuramos conexión con MySQL usando HikariCP.
- Verificamos el inicio correcto del servidor en el puerto `8080`.
- Realizamos pruebas de conexión y levantamiento con **Postman** (los endpoints se están preparando).

## 🧪 Cómo correr el proyecto

### 1. Requisitos

- Tener instalado Java 17+
- Tener MySQL en ejecución
- Tener IntelliJ IDEA o VSCode
- Tener Maven instalado (o usar el wrapper incluido `mvnw`)

### 2. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/Backend-atelier.git
cd Backend-atelier
