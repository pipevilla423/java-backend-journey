# Casos de uso

# ¿Qué es un caso de uso?

Un caso de uso representa una operación completa que el sistema puede realizar.

No es una instrucción.

No es un método cualquiera.

Es una funcionalidad con significado para la aplicación.

Ejemplos de este proyecto:

- registrar entrenador
- agregar Pokémon
- eliminar Pokémon
- cargar entrenadores
- guardar entrenadores

Cada una representa una operación completa del sistema.

---

# Antes del Sprint 10

Todo el flujo estaba dentro del Main.

Era necesario leer muchas líneas para entender cómo funcionaba la aplicación.

---

# Después del Sprint 10

Cada caso de uso quedó representado mediante un método independiente.

Ejemplo:

```java
registrarEntrenadores();

agregarPokemon();

eliminarPokemon();
```

Los nombres de los métodos describen el comportamiento general del programa.

---

# Beneficios

## Legibilidad

El funcionamiento del programa puede entenderse leyendo únicamente el método iniciar().

---

## Mantenimiento

Cada operación se modifica de forma independiente.

No es necesario revisar todo el flujo.

---

## Reutilización

Si una operación vuelve a ser necesaria, simplemente se invoca nuevamente su método.

No hace falta copiar código.

---

# Flujo de alto nivel

El método iniciar() actúa como un resumen del comportamiento del sistema.

```text
Cargar datos

↓

Registrar entrenadores

↓

Agregar Pokémon

↓

Eliminar Pokémon

↓

Guardar datos

↓

Mostrar resultado
```

---

# Lo que aprendí

Un método no solo sirve para dividir código.

También sirve para representar una operación completa del sistema y expresar claramente la intención del programa.