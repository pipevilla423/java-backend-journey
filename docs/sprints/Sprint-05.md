# Sprint 05 — Resultados expresivos con enum

## Objetivo

Hasta el Sprint 4 el método `agregarPokemon()` retornaba un `boolean`, por lo que únicamente era posible saber si la operación había sido exitosa o no.

El objetivo de este sprint fue aprender a comunicar el resultado completo de una operación mediante un `enum`, manteniendo la lógica de negocio separada de la interacción con el usuario.

---

# Funcionalidades implementadas

Se agregó un nuevo tipo de dato:

- EstadoAgregarPokemon

con los siguientes estados:

- POKEMON_AGREGADO
- POKEMON_DUPLICADO
- EQUIPO_LLENO

El método `agregarPokemon()` dejó de retornar un `boolean` y ahora retorna un `EstadoAgregarPokemon`.

Posteriormente `Main` interpreta ese resultado mediante un `switch` para decidir qué mensaje mostrar al usuario.

---

# Conceptos aprendidos

## enum

Aprendí que un enum es un tipo de dato definido por el programador que representa un conjunto limitado de constantes relacionadas entre sí.

En este proyecto el enum representa todos los posibles resultados de intentar agregar un Pokémon al equipo.

---

## Un enum también es un tipo de dato

Antes pensaba que solamente existían tipos primitivos y clases.

Con este sprint aprendí que un enum también crea un nuevo tipo de dato.

Eso permite escribir código como:

```java
EstadoAgregarPokemon estado = entrenador.agregarPokemon(pokemon);
```

de la misma manera que antes utilizaba:

```java
Pokemon pokemon = new Pokemon(...);
```

o

```java
boolean repetido = pokemonDuplicado(pokemon);
```

---

## El boolean dejó de ser suficiente

El boolean únicamente respondía:

- ¿Funcionó?

Cuando retornaba `false`, Main no sabía cuál había sido el problema.

Ahora el método comunica exactamente qué ocurrió.

Ya no responde únicamente si la operación fue exitosa, sino cuál fue el resultado de intentar realizarla.

---

## Separación de responsabilidades

Entrenador únicamente:

- valida reglas
- agrega Pokémon cuando corresponde
- retorna el resultado

Main:

- recibe el resultado
- interpreta el estado
- decide qué acción realizar
- muestra los mensajes correspondientes

Esto permitió eliminar completamente los `System.out.println()` de la clase Entrenador.

---

## switch

Aprendí a utilizar switch para ejecutar acciones diferentes dependiendo del valor retornado por el enum.

Cada estado representa un flujo distinto del programa.

---

# Dificultades

La principal dificultad fue comprender cuándo utilizar un boolean y cuándo un enum.

Inicialmente pensé en agregar mensajes directamente dentro del enum mediante un constructor.

Después entendí que eso mezclaba responsabilidades y que el objetivo del sprint era que Main fuera quien decidiera cómo reaccionar ante cada resultado.

---

# Reflexión

Este sprint me permitió entender que los métodos no solamente deben indicar si una operación fue correcta o incorrecta.

También pueden comunicar exactamente qué ocurrió utilizando un tipo de dato más expresivo.

Además comprendí que un enum no es únicamente una lista de constantes, sino un nuevo tipo de dato que representa un concepto del programa.

Fue un paso importante para seguir mejorando el diseño del proyecto.