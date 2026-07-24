# Teoría 10 — Switch y resultados de operaciones

# ¿Qué es switch?

Switch es una estructura de control que permite ejecutar diferentes bloques de código dependiendo del valor de una variable.

Su objetivo es seleccionar una acción entre varias posibilidades.

Ejemplo:

```java
switch (estado){

    case POKEMON_AGREGADO:
        ...
        break;

    case EQUIPO_LLENO:
        ...
        break;

    case POKEMON_DUPLICADO:
        ...
        break;

}
```

---

# ¿Por qué utilizar switch?

Antes del Sprint 5 el método retornaba un boolean.

Después comenzó a retornar un enum.

Como ahora existen tres posibles resultados, switch resulta más claro que utilizar múltiples if.

Cada caso representa un posible resultado de la operación.

---

# Separación de responsabilidades

Entrenador tiene la responsabilidad de:

- aplicar reglas de negocio
- validar el equipo
- retornar un resultado

Main tiene la responsabilidad de:

- recibir el resultado
- interpretar el resultado
- decidir qué hacer
- mostrar mensajes al usuario

Esto evita que Entrenador conozca detalles de la interfaz.

---

# Flujo de una operación

```
Main

↓

Entrenador.agregarPokemon()

↓

Entrenador aplica reglas

↓

Retorna EstadoAgregarPokemon

↓

Main recibe el resultado

↓

switch

↓

Acción correspondiente
```

---

# Beneficios

- Mejor separación de responsabilidades.
- Métodos más expresivos.
- Código más fácil de mantener.
- Se pueden agregar nuevos estados sin modificar la lógica interna del método.
- El flujo del programa queda centralizado en Main.

---

# Lo aprendido

Una operación puede comunicar mucho más que un simple éxito o fracaso.

En lugar de retornar únicamente un boolean, puede devolver un tipo de dato que describa completamente el resultado.

Ese resultado posteriormente puede ser interpretado por otra parte del programa utilizando switch.

Este patrón aparece constantemente en aplicaciones reales y prepara el camino para aprender excepciones, objetos de resultado y patrones de diseño más avanzados.