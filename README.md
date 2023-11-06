# Descripción de Clases en el Proyecto 📦

Este documento describe las clases clave en el proyecto "Lista de Productos". Cada clase desempeña un papel importante en la funcionalidad de la aplicación.

## Listado de productos 🚀

La clase `BlockNotasApplication` es la clase principal de la aplicación Spring Boot. Esta clase inicia la aplicación y configura el entorno. Implementa la interfaz `CommandLineRunner` para ejecutar código al arrancar la aplicación. Se encarga de inicializar la base de datos MongoDB, insertar algunos productos de ejemplo y configurar la aplicación.

## ProductoController 🎮

`ProductoController` es un controlador Spring que maneja las solicitudes relacionadas con los productos. Proporciona rutas y métodos para listar productos, crear nuevos productos, editar productos existentes y guardar cambios. Utiliza la anotación `@Controller` para definirlo como un controlador de Spring.

## Producto 📝

La clase `Producto` es una clase de modelo que representa un producto en la aplicación. Contiene atributos como el nombre del producto, el identificador del producto, la fecha de creación y la dirección de correo electrónico asociada. Utiliza anotaciones de Spring Data MongoDB para mapear la clase a una colección en MongoDB.

## IProductoDAO 🏛️

`IProductoDAO` es una interfaz que extiende `ReactiveMongoRepository` y define operaciones para acceder y gestionar datos de productos en MongoDB. Proporciona métodos como `findById`, `save` y `delete` para interactuar con la base de datos de manera reactiva.

## ProductoServiceImpl 📡

`ProductoServiceImpl` es una implementación de la interfaz `IProductoService`. Proporciona métodos con lógica de negocio para acceder y manipular productos en la base de datos. Implementa la transformación de nombres de productos a mayúsculas.

## Requisitos 🛠️

Asegúrate de tener instalados los siguientes requisitos en tu entorno de desarrollo:

- Java 17
- MongoDB

Imagen: 

![image](https://github.com/joanvasquez21/proyecto-productos-springboot/assets/70104624/4fd85456-d810-4d9f-adb1-dae9d3b7da28)
