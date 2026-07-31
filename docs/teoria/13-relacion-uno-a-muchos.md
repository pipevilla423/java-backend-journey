# Relaciones uno a muchos

# ¿Qué es una relación uno a muchos?

Es una relación donde un objeto contiene varios objetos del mismo tipo.

Ejemplos:

```text
Cliente
    └── Pedidos
```

```text
Curso
    └── Estudiantes
```

```text
Factura
    └── Productos
```

En este proyecto:

```text
Entrenador
    └── ArrayList<Pokemon>
```

---

# ¿Por qué es diferente de un objeto simple?

Un objeto simple únicamente posee atributos.

Ejemplo:

```text
Entrenador

nombre
región
```

En cambio, un objeto compuesto posee atributos y además contiene otros objetos.

```text
Entrenador

nombre
región

↓

ArrayList<Pokemon>
```

Esto hace que la persistencia sea más compleja.

---

# Representación jerárquica

Para representar una relación uno a muchos se diseñó un formato jerárquico.

```text
Pipe;Alola;Charizard,Fuego,20;Pikachu,Electrico,15
```

Los niveles son:

```text
Entrenador

↓

Pokémon

↓

Atributos del Pokémon
```

Cada nivel utiliza un separador diferente.

---

# Dos niveles de separación

Primer nivel

```text
;
```

Segundo nivel

```text
,
```

Cada separador tiene una única responsabilidad.

Esto hace que la lectura sea sencilla.

---

# Reconstrucción

La reconstrucción ocurre en dos etapas.

Primero:

```java
split(";")
```

Luego:

```java
split(",")
```

Finalmente se crean nuevamente los objetos.

---

# Ventajas

- estructura sencilla
- fácil de leer
- fácil de escribir
- fácil de reconstruir
- no requiere librerías externas

---

# Limitaciones

El formato depende de que los datos no contengan los caracteres utilizados como separadores.

Por ejemplo, si un atributo contiene `;` o `,`, el proceso de lectura dejaría de funcionar correctamente.

Para este proyecto esa limitación es aceptable.