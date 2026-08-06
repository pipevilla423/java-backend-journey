# Referencias a objetos

# ¿Qué es una referencia?

Cuando una variable almacena un objeto, realmente almacena una referencia hacia ese objeto.

Ejemplo:

```java
Pokemon pokemon =
        entrenador.buscarPokemonPorNombre("Pikachu");
```

La variable no contiene una copia del Pokémon.

Contiene una referencia al mismo objeto que está almacenado dentro del equipo del entrenador.

---

# Modificación del objeto

Una vez obtenida la referencia, cualquier cambio realizado sobre ella modifica el mismo objeto.

Ejemplo:

```java
pokemon.cambiarNivel(50);
```

No es necesario volver a insertar el Pokémon dentro del ArrayList.

El objeto ya se encontraba allí.

---

# ¿Por qué funciona?

El ArrayList almacena referencias a objetos.

Cuando se obtiene uno de esos objetos mediante una búsqueda, se trabaja exactamente sobre la misma instancia.

Por esa razón los cambios son visibles desde cualquier lugar que utilice ese objeto.

---

# Lo que NO fue necesario hacer

No fue necesario:

```java
equipo.remove(pokemon);

equipo.add(pokemon);
```

El objeto nunca dejó de pertenecer a la colección.

Únicamente cambió su estado interno.

---

# Beneficios

Trabajar mediante referencias permite:

- evitar crear objetos innecesarios;
- reutilizar las instancias existentes;
- modificar información de forma sencilla;
- mantener la identidad del objeto.

---

# Lo que aprendí

Buscar un objeto no solamente sirve para saber si existe.

También permite obtener una referencia para trabajar directamente sobre él y modificar su estado cuando sea necesario.