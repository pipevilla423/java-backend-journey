# Comandos vs Consultas

# Dos tipos de operaciones

A medida que una aplicación crece, los métodos empiezan a tener propósitos diferentes.

No todos los métodos modifican información.

Es posible clasificarlos en dos grandes grupos.

---

# Comandos

Un comando cambia el estado del sistema.

Después de ejecutarlo, la información almacenada ya no es la misma.

Ejemplos de este proyecto:

```java
registrarEntrenador()

agregarPokemon()

eliminarPokemon()

guardarEntrenadores()
```

Todos producen un cambio permanente.

---

# Consultas

Una consulta únicamente responde una pregunta.

No modifica información.

El estado del sistema permanece exactamente igual antes y después de ejecutarse.

Ejemplos:

```java
buscarEntrenador()

buscarPokemonPorNombre()
```

---

# Diferencia principal

## Comando

```text
Estado inicial

↓

Operación

↓

Estado diferente
```

---

## Consulta

```text
Estado inicial

↓

Consulta

↓

Mismo estado
```

---

# Tipos de retorno

Normalmente un comando devuelve información sobre el resultado de la operación.

Ejemplo:

```java
EstadoAgregarPokemon
```

Una consulta normalmente devuelve la información encontrada.

Ejemplo:

```java
Pokemon

Entrenador
```

o

```java
null
```

cuando no existe.

---

# Beneficios

Separar comandos y consultas hace que el código sea más fácil de entender.

Cuando un método modifica información, queda claro que pertenece a un comando.

Cuando únicamente devuelve datos, pertenece a una consulta.

---

# Lo que aprendí

Antes de crear un método es importante preguntarse:

> ¿Este método cambia el estado del sistema o solamente responde una pregunta?

La respuesta determina el tipo de operación que se está implementando.