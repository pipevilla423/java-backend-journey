# Teoría 09 — Enum

# ¿Qué es un enum?

Un enum es un tipo de dato definido por el programador que representa un conjunto limitado de constantes relacionadas entre sí.

Cada constante representa uno de los posibles valores válidos de un mismo concepto.

Ejemplo:

```java
public enum EstadoAgregarPokemon {

    POKEMON_AGREGADO,
    POKEMON_DUPLICADO,
    EQUIPO_LLENO

}
```

En este caso el concepto representado es:

"Resultado de intentar agregar un Pokémon."

---

# ¿Por qué utilizar un enum?

Antes de este sprint el método retornaba un boolean.

```java
true
false
```

Eso únicamente respondía:

- funcionó
- no funcionó

Pero no explicaba cuál había sido el motivo del fallo.

Con un enum el método puede comunicar exactamente qué ocurrió.

---

# enum vs String

Podría utilizarse un String.

```java
return "POKEMON_DUPLICADO";
```

Sin embargo, un String únicamente representa texto.

No existe ninguna garantía de que el texto pertenezca al conjunto correcto de resultados.

Sería posible escribir accidentalmente:

```java
return "POKEMON_DUPLICDO";
```

y el compilador no detectaría el error.

Con un enum solamente existen las constantes definidas.

```java
EstadoAgregarPokemon.POKEMON_DUPLICADO
```

El compilador detectará cualquier valor inexistente.

---

# Un enum crea un nuevo tipo

Así como una clase crea un tipo:

```java
Pokemon
```

un enum también crea un tipo:

```java
EstadoAgregarPokemon
```

Ese tipo puede utilizarse como:

- variable

```java
EstadoAgregarPokemon estado;
```

- parámetro

```java
public void procesar(EstadoAgregarPokemon estado)
```

- retorno

```java
public EstadoAgregarPokemon agregarPokemon(...)
```

---

# ¿Los enum son objetos?

Sí.

Cada constante del enum es una instancia única creada automáticamente por Java.

Por esa razón no es necesario utilizar:

```java
new EstadoAgregarPokemon(...)
```

Simplemente se utilizan las constantes definidas.

---

# ¿Cuándo utilizar enum?

Cuando un concepto del programa posee un conjunto fijo de valores posibles.

Ejemplos:

- estados de una operación
- días de la semana
- meses
- direcciones
- estados de un pedido
- niveles de dificultad

No deben utilizarse cuando los valores pueden crecer indefinidamente o ser creados por el usuario.