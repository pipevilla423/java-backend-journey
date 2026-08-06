# Actualización del estado de un objeto

# ¿Qué significa actualizar un objeto?

Actualizar un objeto consiste en modificar los valores de sus atributos sin reemplazar la instancia existente.

Ejemplo:

```java
pokemon.cambiarNombre(...);

pokemon.cambiarTipo(...);

pokemon.cambiarNivel(...);
```

El objeto sigue siendo el mismo.

Únicamente cambia su estado.

---

# Responsabilidades durante la actualización

## Aplicacion

Coordina la operación.

No modifica atributos directamente.

---

## Entrenador

Localiza el Pokémon.

Valida reglas relacionadas con el equipo.

---

## Pokemon

Actualiza sus propios atributos.

Es el responsable de modificar su estado interno.

---

# Validaciones

No todas las reglas pertenecen al mismo lugar.

Ejemplo:

## Pokemon

Puede validar reglas relacionadas únicamente con él mismo.

## Entrenador

Debe validar reglas que involucren al resto del equipo.

Ejemplo:

- nombres duplicados.

---

# Reutilización

La actualización reutiliza métodos ya existentes.

Por ejemplo:

```java
buscarPokemonPorNombre(...)
```

No fue necesario volver a implementar la búsqueda.

Esto reduce código duplicado y facilita el mantenimiento.

---

# Evolución futura

Si mañana aparece un nuevo atributo, por ejemplo:

```text
fechaCaptura
```

Las modificaciones se concentrarían en las clases responsables:

- Pokemon → agregar y administrar el nuevo atributo.
- Aplicacion → solicitar el dato al usuario.
- ArchivoEntrenadores → guardar y reconstruir el nuevo atributo.

El resto del sistema permanecería igual.

---

# Lo que aprendí

Actualizar correctamente un objeto no significa romper el encapsulamiento.

Significa localizar el objeto adecuado, validar las reglas necesarias y permitir que el propio objeto modifique su estado mediante sus propios métodos.