# Operaciones de eliminación y encapsulamiento

# ¿Qué significa encapsular una operación?

Encapsular una operación significa que únicamente la clase dueña de la información puede modificar su estado interno.

En este proyecto:

```text
Entrenador

↓

Equipo Pokémon
```

Por lo tanto, únicamente Entrenador debe agregar o eliminar Pokémon.

---

# ¿Por qué Main no modifica el ArrayList?

Si Main hiciera algo como:

```java
entrenador.getEquipo().remove(...)
```

la lógica del negocio quedaría distribuida en varias clases.

Además, cualquier cambio futuro obligaría a modificar diferentes partes del programa.

Por esa razón Main únicamente coordina el flujo.

---

# Comunicación mediante enum

Las operaciones del dominio no imprimen mensajes.

Su responsabilidad consiste en devolver el resultado de la operación.

Ejemplo:

```text
POKEMON_ELIMINADO

EQUIPO_VACIO

POKEMON_NO_ENCONTRADO
```

El Main interpreta ese resultado.

---

# Patrón de una operación del dominio

Todas las operaciones importantes del proyecto comienzan a seguir la misma estructura.

```text
Recibir información

↓

Validar reglas

↓

Si alguna regla falla

↓

Retornar estado

↓

Modificar el objeto

↓

Retornar estado exitoso
```

Este patrón apareció tanto en:

- agregarPokemon()
- eliminarPokemon()

y probablemente se repetirá en futuras operaciones.

---

# Beneficios

## Responsabilidad única

Entrenador administra el equipo.

Main administra el flujo.

Cada clase tiene una única responsabilidad.

---

## Reutilización

Las reglas existen en un solo lugar.

No deben repetirse en Main.

---

## Mantenimiento

Si mañana cambia una regla del equipo, únicamente será necesario modificar Entrenador.

El resto del programa continuará funcionando igual.

---

# Lo que aprendí

El encapsulamiento no consiste únicamente en ocultar atributos.

También implica proteger todas las modificaciones del estado interno mediante métodos que validen las reglas del dominio y comuniquen el resultado de la operación sin depender de la interfaz de usuario.