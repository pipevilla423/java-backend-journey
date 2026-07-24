# Métodos boolean y validaciones

## 1. ¿Qué es un método `boolean`?

Un método `boolean` retorna uno de dos posibles valores:

```java
true
```

o

```java
false
```

Generalmente se utiliza para responder preguntas o indicar si una operación fue exitosa.

Ejemplos:

```java
existePokemon()

pokemonDuplicado()

agregarPokemon()
```

---

## 2. ¿Por qué cambiar `void` por `boolean`?

En el Sprint 3 el método siempre agregaba un Pokémon.

Por eso era suficiente utilizar:

```java
void
```

En el Sprint 4 aparecieron reglas de negocio.

Ahora el método puede:

- agregar correctamente;
- rechazar la operación.

Por esta razón comenzó a retornar un `boolean`.

---

## 3. Comunicación entre métodos

Un método puede comunicar información mediante su valor de retorno.

Ejemplo:

```java
boolean agregado = entrenador.agregarPokemon(pokemon);
```

Después:

```java
if (agregado) {
    ...
}
else {
    ...
}
```

El método informa el resultado sin necesidad de modificar variables externas.

---

## 4. Retorno temprano

Un método no necesita ejecutar todo su código.

Puede finalizar inmediatamente cuando encuentra una condición.

Ejemplo conceptual:

```text
¿Equipo lleno?

↓

Sí

↓

return false
```

El resto del método deja de ejecutarse.

Esto simplifica la lógica y evita estructuras innecesarias.

---

## 5. Métodos auxiliares

Cuando una parte del código realiza una tarea específica, puede separarse en un método independiente.

Ejemplo:

```java
pokemonDuplicado()
```

Esto permite:

- reutilizar código;
- mejorar la legibilidad;
- reducir duplicación;
- facilitar el mantenimiento.

---

## 6. Limitaciones del `boolean`

Un `boolean` solamente puede expresar dos resultados.

```text
true

false
```

No permite indicar la causa específica del resultado.

Por ejemplo:

```text
false
```

puede significar:

- equipo lleno;
- Pokémon repetido;
- nivel inválido;
- otra regla de negocio.

El programa sabe que la operación falló, pero no conoce exactamente el motivo.

---

## 7. Alternativas futuras

Más adelante existen alternativas más expresivas para comunicar resultados.

Algunas son:

- `enum`
- objetos de resultado
- excepciones

Estas permiten informar no solo que una operación falló, sino también la causa específica del fallo.

---

## 8. Idea principal

Los métodos pueden utilizar su valor de retorno para comunicar información a otras clases.

El tipo `boolean` es una solución simple y efectiva cuando únicamente se necesita indicar si una operación fue exitosa o no.

Cuando aparecen muchos posibles resultados, suele ser conveniente utilizar estructuras más expresivas.