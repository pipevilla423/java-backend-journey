# Sprint 3 — Gestión de equipos Pokémon

## 1. ¿Qué construí?

Durante este sprint amplié el sistema para permitir que cada entrenador pudiera tener su propio equipo Pokémon.

Las funcionalidades implementadas fueron:

- Registro de Pokémon con nombre, tipo y nivel.
- Búsqueda de entrenadores por nombre.
- Asociación de un Pokémon con un entrenador existente.
- Manejo del caso en el que el entrenador no existe.
- Visualización de los entrenadores junto con sus equipos Pokémon.

También realicé una refactorización en la forma de registrar Pokémon.

Inicialmente, la clase `Entrenador` recibía los datos del Pokémon y construía el objeto internamente.

Después se modificó el diseño para crear primero el objeto `Pokemon` y posteriormente entregárselo al entrenador:

```java
Pokemon pokemon = new Pokemon(nombre, tipo, nivel);
entrenador.agregarPokemon(pokemon);
```

De esta manera, el entrenador únicamente administra su equipo y no se encarga de crear Pokémon.

---

## 2. Conceptos de Java aprendidos

Durante este sprint aprendí y reforcé los siguientes conceptos:

- Búsqueda secuencial en un `ArrayList`.
- Uso de ciclos `for-each`.
- Comparación de cadenas con `equalsIgnoreCase()`.
- Métodos que retornan objetos.
- Uso del valor `null`.
- Verificación de referencias antes de utilizarlas.
- Relaciones entre objetos.
- Encapsulamiento de colecciones.
- Comunicación entre diferentes clases.
- Creación de objetos antes de pasarlos como argumentos.
- Retorno anticipado dentro de un método.

---

## 3. Decisiones de diseño

### El equipo pertenece al entrenador

Decidí que la colección de Pokémon perteneciera a la clase `Entrenador` porque el equipo es información propia de cada entrenador.

El `GestorEntrenadores` se encarga de administrar la colección de entrenadores, mientras que cada entrenador administra su propio equipo Pokémon.

La relación queda representada de la siguiente manera:

```text
GestorEntrenadores
└── ArrayList<Entrenador>
    └── Entrenador
        └── ArrayList<Pokemon>
```

---

### El gestor busca entrenadores

El método para buscar un entrenador por nombre pertenece a `GestorEntrenadores` porque esta clase conoce y administra la colección de entrenadores.

Esto evita que `Main` tenga que recorrer directamente el `ArrayList<Entrenador>`.

---

### El entrenador agrega Pokémon existentes

Inicialmente, el entrenador recibía los datos del Pokémon y lo construía internamente.

Posteriormente se refactorizó el diseño para que el Pokémon fuera creado antes de llamar al método del entrenador.

El método quedó encargado únicamente de agregar un objeto existente:

```java
public void agregarPokemon(Pokemon pokemon) {
    equipo.add(pokemon);
}
```

Con este cambio, la responsabilidad del entrenador es administrar su equipo, no crear Pokémon.

---

### `Main` coordina el flujo

La clase `Main` se encarga de:

- Solicitar los datos al usuario.
- Crear objetos cuando corresponde.
- Buscar entrenadores mediante el gestor.
- Verificar si el entrenador fue encontrado.
- Llamar a los métodos adecuados.

`Main` no modifica directamente las colecciones internas de las clases.

---

### Retornar `null` cuando no se encuentra un entrenador

El método de búsqueda retorna un objeto `Entrenador` cuando encuentra una coincidencia.

Cuando no existe ningún entrenador con el nombre solicitado, retorna `null`.

El código que recibe el resultado debe verificarlo antes de utilizarlo:

```java
Entrenador entrenador = gestor.buscarEntrenador(nombre);

if (entrenador == null) {
    System.out.println("Entrenador no encontrado");
} else {
    entrenador.agregarPokemon(pokemon);
}
```

---

## 4. Dificultades encontradas

Una de las principales dificultades fue decidir qué clase debía encargarse de agregar y crear Pokémon.

Inicialmente consideré crear una clase adicional para gestionar el equipo del entrenador.

Después comprendí que, por ahora, el equipo es responsabilidad directa de la clase `Entrenador`, ya que todavía no posee suficiente comportamiento independiente para justificar una clase adicional.

También tuve que reflexionar sobre si el entrenador debía crear los objetos `Pokemon` o únicamente recibirlos.

Finalmente decidí crear el objeto antes de entregárselo al entrenador, logrando una separación de responsabilidades más clara.

Otra dificultad fue comprender correctamente el significado de `null`.

Aprendí que `null` no es un objeto, sino que indica que una referencia no apunta a ningún objeto existente.

---

## 5. Posibles refactorizaciones futuras

Algunas mejoras que podrían implementarse en futuros sprints son:

- Evitar exponer directamente el `ArrayList<Pokemon>` mediante un getter modificable.
- Agregar un límite máximo de seis Pokémon por entrenador.
- Validar que no se agreguen Pokémon repetidos.
- Buscar Pokémon dentro del equipo.
- Eliminar o reemplazar Pokémon.
- Mejorar el formato del método `toString()`.
- Separar la entrada por consola de la creación de objetos.
- Utilizar excepciones personalizadas cuando no exista un entrenador.
- Reemplazar `null` por `Optional<Entrenador>` cuando se estudie este concepto.
- Crear una clase `EquipoPokemon` si el equipo adquiere suficientes reglas y comportamientos propios.

---

## 6. Reflexión del Sprint 3

El aprendizaje más importante de este sprint fue comprender que cada clase debe administrar la información que le pertenece.

El `GestorEntrenadores` administra entrenadores.

El `Entrenador` administra su propio equipo.

`Pokemon` representa un Pokémon.

`Main` coordina el flujo general del programa.

También comprendí que una clase no debería asumir responsabilidades adicionales sin necesidad.

El entrenador no necesita crear Pokémon; solamente debe agregar al equipo un Pokémon que ya existe.

Este sprint me permitió empezar a pensar no solo en cómo hacer funcionar el programa, sino también en cómo distribuir correctamente las responsabilidades entre los objetos.