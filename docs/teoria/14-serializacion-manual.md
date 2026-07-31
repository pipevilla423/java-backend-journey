# Serialización manual

# ¿Qué es serializar?

Serializar significa transformar un objeto en un formato que pueda almacenarse.

En este proyecto ese formato es texto plano.

Ejemplo:

Objeto

↓

```text
Pokemon
nombre = Charizard
tipo = Fuego
nivel = 20
```

↓

Texto

```text
Charizard,Fuego,20
```

---

# ¿Qué es deserializar?

Es el proceso contrario.

Texto

↓

```text
Charizard,Fuego,20
```

↓

Objeto

```java
new Pokemon("Charizard","Fuego",20)
```

---

# ¿Por qué hacerlo manualmente?

En este proyecto todavía no se utilizan:

- JSON
- XML
- Bases de datos
- Librerías de serialización

Por eso toda la transformación se realiza mediante código.

---

# Métodos auxiliares

La conversión se centralizó en métodos específicos.

Ejemplo:

```java
convertirPokemonATexto()

convertirTextoAPokemon()
```

Estos métodos encapsulan toda la lógica de transformación.

---

# Beneficios

## Reutilización

La lógica se escribe una sola vez.

---

## Mantenimiento

Si cambia la estructura de `Pokemon`, únicamente deben modificarse estos métodos.

---

## Legibilidad

Los métodos principales de lectura y escritura permanecen simples.

Ejemplo:

```java
guardarEntrenadores()
```

solo coordina el proceso.

Los detalles de la conversión quedan ocultos dentro de métodos auxiliares.

---

# Conversión de tipos

Todo lo que se lee de un archivo es texto.

Por ejemplo:

```text
20
```

Después de leerlo es necesario convertirlo al tipo correcto.

```java
int nivel = Integer.parseInt(datosPokemon[2]);
```

El objeto recupera así el mismo tipo de dato que tenía antes de ser almacenado.

---

# Desacoplamiento

Las clases del dominio no conocen el formato del archivo.

`Pokemon` continúa representando un Pokémon.

`Entrenador` continúa administrando su equipo.

La responsabilidad de transformar objetos hacia y desde texto pertenece únicamente a la clase de persistencia.

Esto permite cambiar el mecanismo de almacenamiento en el futuro con un impacto mínimo sobre el resto del sistema.