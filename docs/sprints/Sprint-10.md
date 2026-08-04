# Sprint 10 - Separación del flujo de la aplicación

# Objetivo

Hasta el Sprint 9 el proyecto ya tenía una buena separación de responsabilidades.

Existían clases dedicadas para:

- administrar entrenadores
- administrar el equipo Pokémon
- administrar la persistencia
- administrar la interacción con consola

Sin embargo, el flujo completo del programa seguía estando dentro del Main.

El objetivo de este sprint fue mover esa responsabilidad a una clase dedicada llamada Aplicacion.

---

# ¿Qué aprendí?

Antes de este sprint el Main era quien conocía todo el funcionamiento del programa.

Sabía:

- qué hacer
- cuándo hacerlo
- en qué orden hacerlo

Después del sprint el Main dejó de coordinar la aplicación.

Ahora únicamente crea una instancia de Aplicacion y ejecuta:

```java
aplicacion.iniciar();
```

La coordinación completa pasó a una clase especializada.

---

# Nueva clase

Durante este sprint apareció:

```java
Aplicacion
```

Su responsabilidad consiste en coordinar el flujo completo del programa.

No contiene reglas del negocio.

No administra archivos.

No administra entrenadores.

Simplemente decide qué operación ejecutar y en qué momento.

---

# Casos de uso

En lugar de tener un único método enorme, el flujo quedó dividido en operaciones independientes.

Ejemplo:

```java
cargarEntrenadores();

registrarEntrenadores();

agregarPokemon();

eliminarPokemon();

guardarEntrenadores();

mostrarEstadoFinal();
```

Al leer únicamente estos nombres ya es posible comprender el funcionamiento general del programa.

---

# Estado compartido

Los objetos principales dejaron de ser variables locales del Main.

Ahora pertenecen a Aplicacion.

Ejemplo:

```java
private final GestorEntrenadores gestor;
private final AdministradorTexto consola;
private final ArchivoEntrenadores archivo;
```

Todos los métodos trabajan sobre esos mismos objetos.

No es necesario retornarlos entre operaciones.

Cada método simplemente modifica su estado.

---

# Responsabilidades

## Main

Únicamente inicia la aplicación.

---

## Aplicacion

Coordina el flujo del programa.

---

## AdministradorTexto

Interactúa con el usuario.

---

## GestorEntrenadores

Administra los entrenadores.

---

## Entrenador

Administra el equipo Pokémon.

---

## ArchivoEntrenadores

Administra la persistencia.

---

# Beneficios

Separar el flujo en métodos pequeños permitió:

- entender rápidamente cómo funciona el programa;
- cambiar fácilmente el orden de ejecución;
- reutilizar operaciones;
- evitar código duplicado;
- mejorar el mantenimiento.

---

# Lo que entendí

Aplicacion no reemplaza a las demás clases.

Simplemente las coordina.

Cada clase continúa teniendo una única responsabilidad y Aplicacion reutiliza sus métodos para construir el flujo completo del sistema.

Este sprint reforzó la idea de que agregar nuevas funcionalidades comienza identificando primero qué clase es responsable de esa nueva regla del negocio y solamente después incorporándola al flujo de la aplicación.