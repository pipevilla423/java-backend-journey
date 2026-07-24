# Sprint 4 — Reglas de negocio para el equipo Pokémon

## 1. ¿Qué construí?

Durante este sprint agregué reglas de negocio para controlar la administración del equipo Pokémon de cada entrenador.

Hasta el Sprint 3 cualquier Pokémon podía agregarse sin restricciones. Ahora el sistema valida que la operación sea válida antes de modificar el equipo.

Las funcionalidades implementadas fueron:

- Limitar el equipo a un máximo de seis Pokémon.
- Evitar Pokémon repetidos por nombre.
- Retornar un valor booleano indicando si la operación fue exitosa.
- Crear un método auxiliar para validar Pokémon duplicados.
- Mantener toda la lógica del equipo dentro de la clase `Entrenador`.

---

## 2. Conceptos de Java aprendidos

Durante este sprint reforcé los siguientes conceptos:

- Métodos que retornan `boolean`.
- Validaciones antes de modificar una colección.
- Uso de `size()` en un `ArrayList`.
- Métodos auxiliares.
- Reutilización de código.
- Reglas de negocio.
- Retorno temprano (`return`).
- Comunicación entre métodos mediante valores de retorno.

---

## 3. Decisiones de diseño

### Las reglas pertenecen a `Entrenador`

Las reglas del equipo se implementaron dentro de la clase `Entrenador` porque esta es la responsable de administrar su propio equipo Pokémon.

La clase `Main` únicamente coordina el flujo del programa y no debe conocer las reglas internas del equipo.

Si las validaciones estuvieran en `Main`, cualquier cambio obligaría a modificar el flujo principal del programa.

Al mantener las reglas dentro de `Entrenador`, cualquier modificación futura solo requiere cambiar una única clase.

---

### `agregarPokemon()` ahora retorna un `boolean`

Anteriormente el método era `void` porque siempre agregaba el Pokémon.

Con la incorporación de reglas de negocio, ahora la operación puede fallar.

Por esta razón el método retorna:

- `true` → el Pokémon fue agregado correctamente.
- `false` → la operación fue rechazada.

Esto permite que `Main` pueda tomar decisiones dependiendo del resultado de la operación.

---

### Validación antes de modificar el estado

Antes de agregar un Pokémon se verifican todas las reglas del equipo.

El flujo quedó de la siguiente manera:

```text
Recibir Pokémon
        │
        ▼
¿Equipo lleno?
        │
     Sí ▼ No
   return false
        │
        ▼
¿Pokémon duplicado?
        │
     Sí ▼ No
   return false
        │
        ▼
Agregar Pokémon
        │
        ▼
return true
```

De esta forma el equipo solo cambia cuando todas las validaciones son correctas.

---

### Separación de la validación de duplicados

La búsqueda de Pokémon repetidos se movió a un método independiente.

Esto permite:

- reutilizar la lógica;
- simplificar `agregarPokemon()`;
- mejorar la lectura del código;
- facilitar el mantenimiento.

---

## 4. Dificultades encontradas

La principal dificultad fue decidir cómo informar a `Main` si la operación había sido exitosa.

Inicialmente el método solamente imprimía mensajes por consola.

Posteriormente comprendí que era mejor retornar un `boolean`, permitiendo que otra clase pudiera conocer el resultado de la operación.

También apareció una nueva reflexión: un `boolean` solo indica si la operación fue exitosa o no, pero no permite conocer la causa específica del rechazo.

---

## 5. Posibles refactorizaciones futuras

Algunas mejoras que podrían implementarse posteriormente son:

- Reemplazar el `boolean` por una estructura que indique el motivo del resultado.
- Eliminar los `System.out.println()` de la clase `Entrenador`.
- Centralizar todos los mensajes en `Main`.
- Crear una clase especializada para administrar el equipo Pokémon.
- Agregar nuevas reglas de negocio.
- Validar niveles permitidos.
- Restringir determinadas especies o categorías de Pokémon.

---

## 6. Reflexión del Sprint 4

El aprendizaje más importante de este sprint fue comprender que una clase no solo almacena información, sino que también protege su propio estado mediante reglas de negocio.

También comprendí que un método puede comunicar el resultado de una operación utilizando su valor de retorno.

Finalmente entendí la importancia de dividir un problema grande en métodos pequeños y reutilizables, logrando un código más organizado y fácil de mantener.