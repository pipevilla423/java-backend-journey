# Sprint 09 - Separación de la interacción con consola

# Objetivo

Hasta el Sprint 8 el programa ya era funcional.

Era capaz de:

- registrar entrenadores
- agregar Pokémon
- eliminar Pokémon
- persistir la información

Sin embargo, el Main seguía teniendo una responsabilidad adicional: manejar toda la interacción con la consola.

El objetivo de este sprint fue separar esa responsabilidad en una clase especializada.

---

# ¿Qué aprendí?

Antes de este sprint el Main hacía dos trabajos diferentes.

- Coordinar el flujo del programa.
- Leer y mostrar información por consola.

Después del sprint el Main dejó de conocer cómo se obtienen o muestran los datos.

Ahora únicamente solicita la información que necesita mediante una clase especializada.

---

# Nueva clase

Durante este sprint apareció una nueva clase:

```java
AdministradorTexto
```

Su responsabilidad consiste en administrar toda la interacción con la consola.

Esta clase encapsula:

- Scanner
- System.out.println()
- lectura de texto
- lectura de enteros
- lectura de decisiones

---

# Centralización

Antes del sprint existían muchas líneas como:

```java
System.out.println(...);

scanner.nextLine();
```

Distribuidas por todo el Main.

Ahora cualquier cambio relacionado con la consola se realiza en un único lugar.

Esto mejora considerablemente el mantenimiento.

---

# Métodos reutilizables

En lugar de crear métodos específicos para cada dato:

```java
pedirNombreEntrenador()

pedirRegion()

pedirNombrePokemon()
```

se diseñaron métodos generales.

Ejemplo:

```java
pedirTexto()

pedirEntero()

pedirDecision()

imprimirMensaje()
```

Todos reutilizan el mismo comportamiento.

Únicamente cambia el mensaje recibido como parámetro.

---

# Uso de un único Scanner

La clase posee un único Scanner como atributo.

Todos los métodos reutilizan ese mismo objeto.

Esto evita crear un Scanner nuevo cada vez que se solicita información y centraliza completamente el acceso a la consola.

---

# Responsabilidades

## Main

Coordina el flujo del programa.

No conoce Scanner ni System.out.

---

## AdministradorTexto

Se encarga de toda la interacción con el usuario.

---

## GestorEntrenadores

Administra entrenadores.

---

## Entrenador

Administra el equipo Pokémon.

---

## ArchivoEntrenadores

Administra la persistencia.

---

# Beneficios

Si mañana cambia la forma de obtener datos del usuario, la modificación se concentra en AdministradorTexto.

Las demás clases no necesitan modificarse porque nunca dependieron directamente de Scanner.

---

# Lo que entendí

Este sprint no agregó nuevas funcionalidades.

Sin embargo, mejoró considerablemente la arquitectura del programa.

Ahora la interacción con la consola se encuentra completamente centralizada.

Esto facilita el mantenimiento, reduce código repetido y prepara el proyecto para futuras formas de interacción con el usuario.