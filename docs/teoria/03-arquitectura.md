# Arquitectura básica

## Responsabilidad de una clase

Cada clase debe tener un propósito específico.

Una clase no debe asumir responsabilidades que pertenecen a otra.

---

## Main

Su responsabilidad es controlar el flujo de la aplicación.

Debe:

- iniciar el programa;
- solicitar datos;
- llamar métodos;
- finalizar el programa.

No debe contener la lógica del negocio.

---

## Gestor

Su responsabilidad es administrar una colección de objetos.

En este proyecto:

```text
GestorEntrenadores
```

Administra todos los entrenadores registrados.

---

## Entidad

Representa un objeto del dominio.

Ejemplo:

```text
Entrenador
Pokemon
```

No administra colecciones.

Representa información.

---

## Separación entre flujo y lógica

Main controla cuándo ocurre una acción.

El gestor sabe cómo realizarla.

Ejemplo:

```java
gestor.registrarEntrenador(nombre,region);
```

---

## Independencia del origen de los datos

Una clase no debe depender de si la información proviene de:

- consola;
- API;
- CSV;
- base de datos.

Solo debe ejecutar su responsabilidad.

---

## Reutilización

En lugar de duplicar lógica:

```java
lista.add(...)
```

se reutilizan métodos existentes.

Esto facilita el mantenimiento.

---

## Arquitectura actual

Usuario

↓

Main

↓

GestorEntrenadores

↓

Entrenador

↓

Pokemon