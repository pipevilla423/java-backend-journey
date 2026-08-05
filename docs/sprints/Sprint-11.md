# Sprint 11 - Consultas del dominio

# Objetivo

Hasta el Sprint 10 el sistema podía modificar información.

Era posible:

- registrar entrenadores;
- agregar Pokémon;
- eliminar Pokémon.

Sin embargo, todavía no existían operaciones para consultar el estado del sistema.

El objetivo de este sprint fue incorporar consultas respetando completamente la arquitectura construida hasta el momento.

---

# ¿Qué aprendí?

Durante los sprints anteriores la mayoría de métodos modificaban el estado del programa.

Ejemplos:

- registrarEntrenador()
- agregarPokemon()
- eliminarPokemon()

En este sprint apareció un nuevo tipo de operación:

```java
buscarPokemonPorNombre()
```

Este método no modifica absolutamente nada.

Únicamente consulta información y devuelve el resultado de la búsqueda.

---

# Comandos y consultas

Comencé a diferenciar dos tipos de métodos.

## Comandos

Modifican el estado del sistema.

Ejemplos:

- agregar Pokémon
- eliminar Pokémon
- registrar entrenador

---

## Consultas

No modifican información.

Únicamente responden preguntas sobre el estado actual del sistema.

Ejemplos:

- buscar entrenador
- buscar Pokémon

---

# Retorno de objetos

En este sprint el método principal devuelve un objeto.

```java
Pokemon buscarPokemonPorNombre(...)
```

Si encuentra el Pokémon retorna una instancia de Pokemon.

Si no existe retorna:

```java
null
```

No utiliza enum porque el objetivo del método no es informar el resultado de una operación, sino entregar la información solicitada.

---

# Encapsulamiento

La búsqueda fue implementada dentro de Entrenador.

No pertenece a Aplicacion.

Entrenador es el dueño del equipo Pokémon.

Por esa razón todas las operaciones relacionadas con esa colección, tanto consultas como modificaciones, deben implementarse allí.

Aplicacion únicamente coordina el flujo.

---

# Flujo de la consulta

La operación quedó organizada de la siguiente manera.

```text
Buscar entrenador

↓

Mostrar equipo

↓

Solicitar nombre del Pokémon

↓

Buscar Pokémon

↓

Mostrar información
```

Cada clase participa únicamente en la responsabilidad que le corresponde.

---

# Experiencia del usuario

Antes de realizar la búsqueda se muestra el equipo completo.

Esto permite que el usuario conozca los Pokémon disponibles antes de escribir el nombre.

La lógica del negocio no cambia.

Únicamente mejora la forma de utilizar la aplicación.

---

# Responsabilidades

## Aplicacion

Coordina la consulta.

---

## GestorEntrenadores

Busca el entrenador.

---

## Entrenador

Busca el Pokémon dentro del equipo.

---

## Pokemon

Representa la información encontrada.

---

## AdministradorTexto

Presenta el resultado al usuario.

---

# Lo que entendí

Una consulta no debe modificar el estado del sistema.

Su única responsabilidad consiste en responder preguntas utilizando la información existente.

Este sprint reforzó la idea de que una nueva funcionalidad debe comenzar identificando qué clase es dueña de la información que se necesita consultar.