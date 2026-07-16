# Sprint 1 - Modelo del dominio

## ¿Qué construí?

Construí las bases del proyecto creando las primeras clases del dominio (`Pokemon` y `Entrenador`) y aprendiendo cómo crear objetos a partir de estas clases.

---

## ¿Qué conceptos de Java aprendí?

- Clases
- Objetos
- Encapsulamiento
- Constructores
- ArrayList
- Métodos
- Getters
- `toString()`

---

## ¿Qué decisiones de diseño tomé y por qué?

- Decidí crear un `ArrayList<Pokemon>` dentro de la clase `Entrenador` para representar el equipo de Pokémon y poder almacenar múltiples objetos de tipo `Pokemon`.
- Elegí representar el tipo de un Pokémon mediante un `String`, ya que en esta etapa del proyecto no era necesario modelar las mecánicas de tipos y quería mantener el diseño lo más simple posible.

---

## ¿Qué dificultades tuve y cómo las resolví?

Al comenzar, no sabía cómo construir un constructor, cómo inicializar un `ArrayList` dentro de él ni cómo utilizarlo correctamente. Resolví estas dificultades estudiando la teoría y revisando implementaciones similares para comprender su funcionamiento.

---

## ¿Qué mejoraría si tuviera que refactorizar este sprint?

Exploraría una mejor forma de representar los tipos de Pokémon pensando en futuras mecánicas del juego, cuando el proyecto requiera un modelo más completo.
