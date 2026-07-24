# Reglas de negocio

## 1. ¿Qué es una regla de negocio?

Una regla de negocio es una condición que debe cumplirse para que una operación sea válida dentro de una aplicación.

No depende del lenguaje de programación ni de la interfaz gráfica.

Representa una restricción propia del problema que se está resolviendo.

Ejemplos del proyecto:

- Un entrenador puede tener máximo seis Pokémon.
- No puede existir un Pokémon repetido dentro del mismo equipo.

---

## 2. ¿Dónde deben implementarse?

Las reglas deben implementarse en la clase responsable de administrar la información.

En este proyecto:

```text
Entrenador
└── administra el equipo Pokémon
```

Por esta razón, las validaciones pertenecen a `Entrenador`.

No deberían implementarse en `Main`.

---

## 3. ¿Por qué no validar en Main?

Si `Main` validara todas las reglas:

- tendría demasiadas responsabilidades;
- conocería detalles internos del equipo;
- cualquier cambio obligaría a modificar el flujo principal.

En cambio:

```text
Main

↓

Entrenador.agregarPokemon()

↓

Entrenador aplica todas las reglas
```

Toda la lógica queda concentrada en un solo lugar.

---

## 4. Validar antes de modificar

Siempre es recomendable comprobar todas las condiciones antes de modificar el estado del objeto.

Ejemplo:

```text
Recibir Pokémon

↓

Validar reglas

↓

Agregar solo si todas son correctas
```

Esto evita inconsistencias dentro de la aplicación.

---

## 5. Centralización de reglas

Concentrar las reglas en un único método tiene varias ventajas.

- Evita duplicar código.
- Facilita el mantenimiento.
- Reduce errores.
- Hace el programa más reutilizable.
- Permite que cualquier parte del programa utilice las mismas validaciones.

---

## 6. Beneficios

Aplicar correctamente las reglas de negocio permite:

- proteger el estado de los objetos;
- evitar datos inválidos;
- facilitar futuras modificaciones;
- mantener una arquitectura más limpia.

---

## 7. Idea principal

Las reglas de negocio pertenecen a la clase que administra la información.

En este proyecto:

```text
Entrenador
↓

Protege el equipo Pokémon
↓

Aplica todas las validaciones
↓

Modifica el equipo únicamente cuando la operación es válida
```
Finalmente entendí la importancia de dividir un problema grande en métodos pequeños y reutilizables, logrando un código más organizado y fácil de mantener.