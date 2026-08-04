# Separación entre lógica y presentación

# ¿Qué es la lógica del programa?

La lógica del programa representa las reglas del negocio.

En este proyecto, por ejemplo:

- registrar entrenadores
- agregar Pokémon
- eliminar Pokémon
- validar duplicados
- validar tamaño del equipo

Estas reglas no dependen de la forma en que el usuario interactúa con la aplicación.

---

# ¿Qué es la presentación?

La presentación es la forma en que el usuario se comunica con el programa.

Ejemplos:

- consola
- interfaz gráfica
- página web
- aplicación móvil

La presentación únicamente obtiene información del usuario y muestra resultados.

No debería contener reglas del negocio.

---

# Problema inicial

Antes del Sprint 9 el Main hacía ambas tareas.

```text
Coordinar programa

↓

Leer datos

↓

Mostrar mensajes
```

Esto mezclaba responsabilidades.

---

# Solución

Se creó una clase dedicada.

```text
AdministradorTexto
```

Ahora el flujo queda así:

```text
Usuario

↓

AdministradorTexto

↓

Main

↓

GestorEntrenadores

↓

Entrenador
```

Cada clase tiene una única responsabilidad.

---

# Beneficios

## Mantenimiento

Si cambia la forma de leer datos, únicamente cambia AdministradorTexto.

---

## Reutilización

Todos los métodos reutilizan el mismo Scanner.

---

## Legibilidad

El Main deja de tener decenas de líneas relacionadas con Scanner y System.out.

Su código representa únicamente el flujo del programa.

---

# Principio aprendido

Una clase no debe hacer trabajos que pertenecen a otra.

La interacción con el usuario y la lógica del negocio son responsabilidades diferentes y deben permanecer separadas.