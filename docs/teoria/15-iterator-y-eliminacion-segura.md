# Iterator y eliminación segura

# ¿Qué es un Iterator?

Un Iterator es un objeto encargado de recorrer una colección elemento por elemento.

No trabaja utilizando índices.

Su recorrido consiste en preguntar si existe un siguiente elemento y avanzar hacia él.

---

# ¿Cómo se obtiene?

No se crea con:

```java
new Iterator()
```

Se obtiene desde la colección.

Ejemplo:

```java
Iterator<Pokemon> iterador = equipo.iterator();
```

El propio ArrayList crea el Iterator.

---

# Métodos principales

## hasNext()

Pregunta si todavía existe otro elemento para recorrer.

Devuelve:

```java
true
```

o

```java
false
```

---

## next()

Avanza al siguiente elemento y lo devuelve.

Cada llamada mueve el recorrido hacia adelante.

---

## remove()

Elimina el último elemento obtenido mediante next().

La eliminación es segura porque el mismo Iterator controla tanto el recorrido como la modificación de la colección.

---

# ¿Por qué no usar remove() directamente?

Modificar un ArrayList mientras se está recorriendo puede romper el recorrido.

El for-each utiliza internamente un Iterator.

Si la colección cambia mediante otro mecanismo, el Iterator detecta que el recorrido dejó de ser válido.

Por esa razón existe iterator.remove().

---

# Flujo del recorrido

```text
Crear Iterator

↓

¿Hay siguiente?

↓

Sí

↓

Obtener siguiente elemento

↓

¿Cumple la condición?

↓

Sí

↓

Eliminar

↓

Retornar
```

---

# Retorno anticipado

Después de eliminar el elemento buscado, el método termina inmediatamente.

No existe ninguna razón para seguir recorriendo la colección.

Esto mejora la eficiencia y simplifica el flujo del algoritmo.

---

# Ventajas

- recorrido seguro
- eliminación segura
- evita modificar índices manualmente
- código más claro
- patrón reutilizable en otras colecciones