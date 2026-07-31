# Sprint 07 - Persistencia de relaciones entre objetos

# Objetivo

Hasta el Sprint 6 el sistema era capaz de guardar entrenadores entre ejecuciones.

Sin embargo, los Pokémon pertenecientes a cada entrenador únicamente existían en memoria. Al cerrar el programa, los entrenadores se recuperaban correctamente, pero sus equipos quedaban vacíos.

El objetivo de este sprint fue extender la persistencia para conservar también la relación entre un entrenador y su equipo Pokémon.

---

# ¿Qué aprendí?

En el Sprint 6 persistía objetos independientes.

Cada línea del archivo representaba un único entrenador.

En este sprint apareció un problema diferente: persistir una relación uno a muchos.

Un entrenador ya no era un objeto simple.

Ahora contenía un:

```java
ArrayList<Pokemon>
```

Esto obligó a diseñar un formato capaz de representar tanto al entrenador como todos los Pokémon pertenecientes a su equipo.

---

# Nuevo problema

Antes el archivo tenía una estructura simple.

```text
Pipe;Alola
```

Ahora una misma línea debía contener varios objetos relacionados.

Ejemplo:

```text
Pipe;Alola;Charizard,Fuego,20;Pikachu,Electrico,15
```

Fue necesario diseñar una jerarquía dentro del archivo.

---

# Diseño del formato

Se utilizaron dos niveles de separación.

## Primer nivel

El carácter:

```text
;
```

se utiliza para separar:

- nombre del entrenador
- región
- cada Pokémon

Ejemplo:

```text
Pipe
Alola
Charizard,Fuego,20
Pikachu,Electrico,15
```

---

## Segundo nivel

El carácter:

```text
,
```

se utiliza para separar los atributos internos de un Pokémon.

Ejemplo:

```text
Charizard,Fuego,20
```

Después de ejecutar:

```java
split(",")
```

se obtiene:

```text
nombre
tipo
nivel
```

---

# Arquitectura

La responsabilidad de la persistencia continúa estando dentro de:

```text
ArchivoEntrenadores
```

No se modificó la responsabilidad de las demás clases.

## Main

Coordina el flujo.

## GestorEntrenadores

Administra entrenadores.

## Entrenador

Administra su equipo y valida las reglas.

## ArchivoEntrenadores

Transforma objetos en texto y texto en objetos.

---

# Métodos auxiliares

Durante este sprint aparecieron nuevos métodos privados.

Ejemplo:

```java
convertirPokemonATexto()

convertirTextoAPokemon()
```

Estos métodos permiten separar la lógica de conversión de la lógica principal de lectura y escritura.

---

# Beneficios

La conversión queda centralizada.

Si mañana `Pokemon` recibe nuevos atributos únicamente será necesario modificar estos métodos.

Los métodos principales continúan siendo fáciles de leer.

---

# Reconstrucción del equipo

Después de leer una línea del archivo se obtiene primero:

```java
split(";")
```

Las dos primeras posiciones corresponden al entrenador.

A partir de la posición 2 comienzan los Pokémon.

Cada Pokémon vuelve a dividirse utilizando:

```java
split(",")
```

Con esa información se reconstruyen los objetos.

---

# Reutilización de reglas

Durante la carga no se modifica directamente el ArrayList.

Cada Pokémon se agrega utilizando:

```java
agregarPokemon()
```

De esta manera continúan aplicándose todas las reglas del dominio.

- máximo seis Pokémon
- sin duplicados

La persistencia respeta las mismas reglas que utiliza el resto del programa.

---

# Lo que entendí

Persistir relaciones entre objetos no consiste únicamente en guardar más información.

También implica diseñar una representación que permita reconstruir correctamente la estructura original del programa.

En este sprint aprendí que un archivo también puede representar jerarquías y relaciones entre objetos utilizando un formato bien definido.