# `null` y retorno de objetos

## 1. Métodos que retornan objetos

Un método no solamente puede retornar valores primitivos como `int`, `double` o `boolean`.

También puede retornar objetos.

Por ejemplo:

```java
public Entrenador buscarEntrenador(String nombre) {
    // lógica de búsqueda
}
```

En este caso, el tipo de retorno es:

```java
Entrenador
```

Esto significa que el método debe devolver una referencia a un objeto `Entrenador` o devolver `null`.

---

## 2. Búsqueda secuencial

Para buscar un entrenador dentro de un `ArrayList`, se puede recorrer la colección utilizando un ciclo `for-each`.

Ejemplo:

```java
public Entrenador buscarEntrenador(String nombre) {

    for (Entrenador entrenador : entrenadores) {
        if (entrenador.getNombre().equalsIgnoreCase(nombre)) {
            return entrenador;
        }
    }

    return null;
}
```

El método revisa cada entrenador hasta encontrar uno cuyo nombre coincida.

---

## 3. Retorno anticipado

Cuando se encuentra el entrenador, se utiliza:

```java
return entrenador;
```

Esto finaliza inmediatamente la ejecución del método y devuelve el objeto encontrado.

No es necesario continuar recorriendo la colección después de encontrar una coincidencia.

A esto se le puede llamar retorno anticipado.

---

## 4. Comparación de cadenas

Para comparar el contenido de dos objetos `String` se utiliza:

```java
equals()
```

o:

```java
equalsIgnoreCase()
```

Ejemplo:

```java
entrenador.getNombre().equalsIgnoreCase(nombre)
```

`equalsIgnoreCase()` permite que las mayúsculas y minúsculas no afecten la búsqueda.

Por ejemplo, considera equivalentes:

```text
Ash
ash
ASH
```

No se debe utilizar `==` para comparar el contenido de dos cadenas.

```java
nombre1 == nombre2
```

`==` compara referencias, no necesariamente el contenido del texto.

---

## 5. ¿Qué significa `null`?

`null` indica que una referencia no apunta a ningún objeto.

Ejemplo:

```java
Entrenador entrenador = null;
```

En esta instrucción no se creó un objeto `Entrenador`.

Solo se declaró una variable cuya referencia no apunta a ningún objeto.

Por eso, no es correcto decir que `null` es un objeto.

Es más preciso decir:

> La referencia vale `null`.

o:

> La referencia no apunta a ningún objeto.

---

## 6. Uso de `null` en una búsqueda

Cuando un método busca un entrenador, existen dos resultados posibles.

### El entrenador existe

El método devuelve la referencia al objeto encontrado:

```java
return entrenador;
```

### El entrenador no existe

El método devuelve:

```java
return null;
```

Esto indica que no fue posible encontrar un objeto que cumpliera la condición.

---

## 7. Verificación de `null`

Antes de utilizar el resultado de una búsqueda, se debe comprobar si la referencia vale `null`.

```java
Entrenador entrenador = gestor.buscarEntrenador(nombre);

if (entrenador == null) {
    System.out.println("Entrenador no encontrado");
} else {
    entrenador.agregarPokemon(pokemon);
}
```

Solo se debe llamar a métodos del entrenador cuando la referencia apunta a un objeto válido.

---

## 8. `NullPointerException`

Si se intenta utilizar una referencia `null`, Java produce una excepción llamada:

```text
NullPointerException
```

Por ejemplo:

```java
Entrenador entrenador = null;
entrenador.agregarPokemon(pokemon);
```

La segunda línea falla porque la variable `entrenador` no apunta a ningún objeto sobre el cual se pueda ejecutar el método.

Por eso es necesario verificar la referencia antes de utilizarla.

---

## 9. Diferencia entre devolver un objeto y mostrarlo

Un método de búsqueda debe devolver el objeto, no limitarse a imprimirlo.

No sería suficiente hacer esto:

```java
System.out.println("Entrenador encontrado");
```

El resto del programa necesita obtener el objeto para poder realizar otras acciones, como agregar un Pokémon.

Por eso el método retorna:

```java
return entrenador;
```

Luego el objeto puede almacenarse en una variable:

```java
Entrenador entrenadorEncontrado =
        gestor.buscarEntrenador(nombre);
```

---

## 10. ¿Por qué no retornar un `boolean`?

Un método podría retornar `true` si el entrenador existe y `false` si no existe.

Sin embargo, eso solo indicaría la existencia del entrenador.

El programa todavía necesitaría volver a buscarlo para poder utilizarlo.

Ejemplo poco conveniente:

```text
¿Existe el entrenador?
→ sí

Buscar nuevamente el entrenador
→ obtener el objeto
```

Es más útil devolver directamente el objeto encontrado:

```java
Entrenador entrenador = gestor.buscarEntrenador(nombre);
```

Después se puede verificar si el resultado es `null`.

---

## 11. Ventajas y riesgos de utilizar `null`

### Ventajas

- Es sencillo.
- Permite representar que una búsqueda no encontró resultados.
- Es adecuado para programas pequeños y etapas iniciales de aprendizaje.

### Riesgos

- El código puede olvidar verificarlo.
- Puede producir una `NullPointerException`.
- No explica por sí mismo por qué no existe un resultado.

Por esta razón, el código que recibe una posible referencia `null` debe tratarla cuidadosamente.

---

## 12. Alternativas futuras

Existen alternativas más avanzadas para representar la ausencia de un resultado.

### `Optional`

En versiones modernas de Java puede utilizarse:

```java
Optional<Entrenador>
```

Esto hace explícito que el método puede encontrar o no un entrenador.

### Excepciones

También podría lanzarse una excepción cuando el entrenador no existe:

```java
throw new EntrenadorNoEncontradoException();
```

Estas alternativas se estudiarán en futuros sprints.

Para el Sprint 3, retornar `null` es una solución adecuada y suficiente.

---

## 13. Idea principal

Un método de búsqueda puede devolver:

```text
Una referencia al objeto encontrado
```

o:

```text
null
```

El código que recibe el resultado debe verificarlo antes de utilizarlo.

El flujo general es:

```text
buscar objeto
│
├── se encuentra
│   └── retornar el objeto
│
└── no se encuentra
    └── retornar null
```

Después:

```text
recibir resultado
│
├── resultado == null
│   └── informar que no existe
│
└── resultado != null
    └── utilizar el objeto
```