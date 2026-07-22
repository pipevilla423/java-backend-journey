# Relaciones entre objetos

## 1. ¿Qué es una relación entre objetos?

En programación orientada a objetos, una clase puede contener, utilizar o colaborar con objetos de otras clases.

Esto permite representar relaciones del mundo real dentro del programa.

Por ejemplo, en el proyecto PokéLeague Manager existe la siguiente relación:

```text
Entrenador
└── ArrayList<Pokemon>
```

Un entrenador puede tener varios Pokémon, por lo que la clase `Entrenador` contiene una colección de objetos `Pokemon`.

---

## 2. Relación entre `Entrenador` y `Pokemon`

El equipo pertenece al entrenador porque es información propia de esa entidad.

Cada entrenador tiene su propio equipo y debe poder administrar las operaciones relacionadas con él.

Ejemplo conceptual:

```java
public class Entrenador {

    private String nombre;
    private String region;
    private ArrayList<Pokemon> equipo;
}
```

La colección se encuentra dentro del entrenador porque representa parte de su estado.

---

## 3. Responsabilidades de las clases

### `GestorEntrenadores`

Se encarga de administrar la colección general de entrenadores.

Sus responsabilidades pueden incluir:

- Registrar entrenadores.
- Buscar entrenadores.
- Mostrar entrenadores.
- Mantener la colección de entrenadores.

No debería administrar directamente los equipos Pokémon de cada entrenador.

---

### `Entrenador`

Representa a un entrenador individual.

Sus responsabilidades incluyen:

- Guardar su nombre.
- Guardar su región.
- Mantener su equipo Pokémon.
- Agregar Pokémon al equipo.
- Aplicar futuras reglas relacionadas con el equipo.

---

### `Pokemon`

Representa un Pokémon individual.

Puede contener atributos como:

- Nombre.
- Tipo.
- Nivel.

Su responsabilidad es representar la información y el estado de un Pokémon.

---

### `Main`

Coordina el flujo general del programa.

Sus responsabilidades incluyen:

- Solicitar datos.
- Crear objetos.
- Invocar métodos.
- Evaluar resultados.
- Mostrar información al usuario.

No debería administrar directamente las colecciones internas de las demás clases.

---

## 4. ¿Quién es dueño de la información?

Una pregunta útil al diseñar una aplicación es:

> ¿A qué objeto pertenece esta información?

En este proyecto:

- La colección de entrenadores pertenece a `GestorEntrenadores`.
- El equipo Pokémon pertenece a `Entrenador`.
- Los datos de un Pokémon pertenecen a `Pokemon`.

Identificar correctamente al dueño de la información ayuda a decidir en qué clase debe ubicarse cada atributo y cada método.

---

## 5. Encapsulamiento de colecciones

Una colección no debería ser modificada libremente por cualquier parte del programa.

Por ejemplo, no es recomendable que `Main` haga directamente:

```java
entrenador.getEquipo().add(pokemon);
```

Esto permite que una clase externa modifique la colección sin respetar las reglas del entrenador.

Es preferible utilizar:

```java
entrenador.agregarPokemon(pokemon);
```

De esta manera, el entrenador conserva el control sobre su equipo.

---

## 6. Beneficios de administrar la colección mediante métodos

Utilizar métodos específicos tiene varias ventajas:

- Protege el estado interno del objeto.
- Centraliza las reglas del equipo.
- Evita duplicar lógica.
- Facilita futuras validaciones.
- Reduce el acoplamiento entre clases.

Por ejemplo, si posteriormente el equipo tiene un límite de seis Pokémon, la validación puede agregarse dentro de `agregarPokemon()`.

```java
public void agregarPokemon(Pokemon pokemon) {
    if (equipo.size() < 6) {
        equipo.add(pokemon);
    }
}
```

Así, `Main` no necesita conocer la regla.

---

## 7. Creación de objetos y administración de objetos

Crear un objeto y administrarlo son responsabilidades diferentes.

Por ejemplo:

```java
Pokemon pokemon = new Pokemon(nombre, tipo, nivel);
entrenador.agregarPokemon(pokemon);
```

En este flujo:

1. Se construye un objeto `Pokemon`.
2. El objeto ya creado se entrega al entrenador.
3. El entrenador lo agrega a su equipo.

El entrenador no necesita conocer cómo se obtuvo la información ni cómo se construyó el Pokémon.

Solo necesita recibir un objeto válido.

---

## 8. Ventajas de recibir objetos completos

Un método como este:

```java
public void agregarPokemon(Pokemon pokemon)
```

es más flexible que uno que reciba cada atributo por separado:

```java
public void agregarPokemon(String nombre, String tipo, int nivel)
```

La primera opción evita que el método tenga que cambiar cada vez que se agrega un atributo a la clase `Pokemon`.

Aunque `Pokemon` llegara a tener muchos atributos, el método del entrenador seguiría siendo el mismo:

```java
agregarPokemon(Pokemon pokemon)
```

Esto reduce el acoplamiento entre las clases.

---

## 9. Flujo de colaboración entre objetos

En el Sprint 3, las clases colaboran de la siguiente manera:

```text
Main
│
├── solicita los datos
├── crea el Pokemon
├── solicita al gestor buscar un entrenador
│
└── entrega el Pokemon al entrenador encontrado

GestorEntrenadores
│
└── busca dentro de la colección de entrenadores

Entrenador
│
└── agrega el Pokemon a su equipo

Pokemon
│
└── representa los datos del Pokémon
```

Cada clase participa en el proceso, pero conserva una responsabilidad diferente.

---

## 10. Posible evolución: `EquipoPokemon`

Por ahora, el equipo puede representarse directamente mediante:

```java
ArrayList<Pokemon>
```

Sin embargo, si en el futuro aparecen muchas reglas propias del equipo, podría justificarse una clase independiente:

```text
Entrenador
└── EquipoPokemon
    └── ArrayList<Pokemon>
```

Una clase `EquipoPokemon` podría encargarse de:

- Limitar el equipo a seis Pokémon.
- Evitar duplicados.
- Buscar integrantes.
- Eliminar Pokémon.
- Reemplazar Pokémon.
- Calcular estadísticas del equipo.

No se debe crear una clase adicional solo por tener un `ArrayList`.

Debe existir una responsabilidad suficiente que justifique su creación.

---

## 11. Idea principal

Una clase debe administrar la información que le pertenece.

En este proyecto:

```text
GestorEntrenadores administra entrenadores.

Entrenador administra su equipo.

Pokemon representa un Pokémon.

Main coordina el flujo.
```

Esta separación permite construir un programa más organizado, reutilizable y fácil de modificar.