# CineApp

Aplicacion de consola en Java para simular la gestion basica de un cine. Permite registrar clientes, visualizar la cartelera, comprar entradas y consultar las entradas asociadas a cada cliente.

## Funcionalidades

- Crear clientes.
- Ver cartelera disponible.
- Comprar entradas para una funcion.
- Validar disponibilidad de asientos.
- Consultar entradas compradas por un cliente.

## Estructura del proyecto

```text
src/
  app/
    Main.java
  model/
    Persona.java
    Cliente.java
    Pelicula.java
    Funcion.java
    Entrada.java
  service/
    CineService.java
  util/
    InputUtil.java
```

## Tecnologias

- Java
- Programacion orientada a objetos
- Ejecucion por consola

## Requisitos

- JDK 17 o superior
- Terminal o IDE compatible con Java

## Como ejecutar

1. Clona el repositorio:

```bash
git clone https://github.com/Miussette/CineApp.git
cd CineApp
```

2. Compila el proyecto:

```bash
javac -d out src/app/Main.java src/model/*.java src/service/*.java src/util/*.java
```

3. Ejecuta la aplicacion:

```bash
java -cp out app.Main
```

## Menu principal

La aplicacion muestra el siguiente flujo en consola:

```text
1) Crear cliente
2) Ver cartelera
3) Comprar entrada
4) Ver entradas del cliente
0) Salir
```

## Funcionamiento actual

- Las funciones se cargan al iniciar la aplicacion.
- Actualmente se agregan dos peliculas de ejemplo: `Avengers` y `Spiderman`.
- Cada funcion tiene una capacidad inicial de 5 asientos.
- Las entradas se almacenan en memoria durante la ejecucion.

## Posibles mejoras

- Persistencia de datos en archivos o base de datos.
- Validacion de rangos de asiento.
- Gestion dinamica de peliculas y funciones.
- Interfaz grafica o API REST.
- Pruebas unitarias.

## Autor

Miussette
