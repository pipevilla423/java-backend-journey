# Sprint 08 - Eliminación de Pokémon del equipo

# Objetivo

Hasta el Sprint 7 el entrenador únicamente podía agregar Pokémon a su equipo.

Sin embargo, una vez agregado un Pokémon no existía ninguna forma de eliminarlo.

El objetivo de este sprint fue implementar una operación de eliminación manteniendo las reglas del dominio, el encapsulamiento y la arquitectura construida en los sprints anteriores.

---

# ¿Qué aprendí?

Agregar y eliminar son operaciones opuestas, pero ambas deben seguir el mismo diseño.

Las dos modifican el estado interno del entrenador y, por lo tanto, ambas deben validar las reglas antes de realizar cualquier cambio.

También comprendí que las operaciones del dominio no deben imprimir mensajes por consola, sino comunicar su resultado mediante un enum para que el Main decida cómo actuar.

---

# Responsabilidades

## Main

Su responsabilidad continúa siendo coordinar el flujo.

- solicita el nombre del entrenador
- solicita el nombre del Pokémon
- llama al método correspondiente
- interpreta el resultado del enum

No elimina Pokémon directamente.

---

## Entrenador

Continúa siendo el dueño del equipo.

Toda modificación del equipo debe realizarse mediante sus propios métodos.

En este sprint se agregó:

```java
eliminarPokemon(...)
```

---

# Uso de Iterator

Durante este sprint apareció un problema importante.

No es seguro modificar una colección mientras se está recorriendo.

Por esta razón se utilizó un Iterator.

Su responsabilidad es recorrer la colección y permitir eliminar elementos sin romper el recorrido.

---

# Validaciones

Antes de comenzar el recorrido se verifica:

- si el equipo está vacío

No tiene sentido crear un Iterator y recorrer la colección cuando ya se sabe que la eliminación es imposible.

Esto mejora la claridad del método y evita trabajo innecesario.

---

# Identificación del Pokémon

La eliminación se realiza utilizando únicamente el nombre.

Esto es posible porque una regla implementada anteriormente impide que un entrenador tenga dos Pokémon con el mismo nombre.

Por lo tanto, el nombre identifica de manera única un Pokémon dentro del equipo.

---

# Retorno anticipado

Una vez encontrado el Pokémon:

- se elimina
- se retorna inmediatamente el estado correspondiente

No existe razón para continuar recorriendo el resto del equipo porque la búsqueda ya terminó.

---

# Comunicación mediante enum

Al igual que en Sprint 5, el método no devuelve un boolean.

Devuelve un enum.

Esto permite comunicar exactamente qué ocurrió.

Ejemplo:

- Pokémon eliminado
- Equipo vacío
- Pokémon no encontrado

El Main interpreta ese resultado y decide qué mensaje mostrar.

---

# Patrón que empecé a repetir

Durante este sprint noté que tanto agregar como eliminar siguen la misma estructura.

```text
Recibir datos

↓

Validar reglas

↓

Si falla → retornar estado

↓

Modificar el equipo

↓

Retornar resultado
```

Este patrón mantiene la lógica del negocio dentro del entrenador y evita que el Main conozca detalles de implementación.

---

# Lo que entendí

Encapsular no significa únicamente hacer privados los atributos.

También significa que toda modificación del estado interno debe realizarse mediante métodos que protejan las reglas del objeto.

En este sprint reforcé esa idea implementando una operación inversa a agregarPokemon() sin romper la arquitectura del proyecto.