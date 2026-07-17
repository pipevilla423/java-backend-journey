# Convenciones de Java

## Clases

Las clases comienzan con mayúscula.

Ejemplo:

```java
Pokemon
Entrenador
GestorEntrenadores
```

---

## Métodos

Los métodos comienzan con minúscula.

Ejemplo:

```java
registrarEntrenador()
agregarPokemon()
mostrarEntrenadores()
```

---

## Nombres de métodos

El nombre debe representar exactamente lo que hace.

Incorrecto:

```java
crearEntrenador()
```

Correcto:

```java
registrarEntrenador()
```

porque además de crearlo, lo registra.

---

## System.out.println()

Cuando un objeto sobrescribe `toString()`, no es necesario llamarlo explícitamente.

Correcto:

```java
System.out.println(entrenador);
```

No recomendado:

```java
System.out.println(entrenador.toString());
```