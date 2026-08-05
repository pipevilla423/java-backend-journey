# Métodos de consulta

# ¿Qué es un método de consulta?

Es un método cuya única responsabilidad consiste en obtener información.

No modifica atributos.

No elimina elementos.

No agrega nuevos objetos.

Únicamente consulta el estado actual del sistema.

---

# Ejemplo

```java
Pokemon buscarPokemonPorNombre(String nombre)
```

Este método recorre el equipo del entrenador.

Si encuentra el Pokémon lo retorna.

Si no existe retorna:

```java
null
```

En ningún momento modifica el equipo.

---

# ¿Dónde deben implementarse?

Una consulta debe implementarse en la clase que posee la información.

Ejemplo:

```text
GestorEntrenadores

↓

Busca entrenadores
```

```text
Entrenador

↓

Busca Pokémon
```

No corresponde que otra clase recorra esas colecciones.

---

# Consultar no significa imprimir

Un método de consulta devuelve información.

No la muestra por pantalla.

Ejemplo:

```java
Pokemon pokemon =
        entrenador.buscarPokemonPorNombre(...);
```

Después:

```java
Aplicacion
```

decide qué hacer con ese resultado.

Finalmente:

```java
AdministradorTexto
```

es quien lo presenta al usuario.

---

# Beneficios

## Encapsulamiento

La colección continúa siendo administrada únicamente por su dueño.

---

## Reutilización

La misma consulta puede utilizarse desde distintas partes del programa.

---

## Mantenimiento

Si cambia la forma de buscar un Pokémon, únicamente será necesario modificar ese método.

El resto de la aplicación continuará funcionando igual.

---

# Lo que aprendí

El criterio para decidir dónde implementar una consulta consiste en identificar quién es el dueño de la información.

La clase propietaria de los datos debe ser también la responsable de responder preguntas sobre ellos.