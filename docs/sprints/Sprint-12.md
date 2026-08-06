# Sprint 12 - Actualización del estado de un Pokémon

# Objetivo

Hasta el Sprint 11 el sistema ya permitía crear, consultar y eliminar Pokémon.

Sin embargo, una vez creado un Pokémon, su información permanecía fija.

El objetivo de este sprint fue permitir actualizar la información de un Pokémon existente respetando la arquitectura del proyecto y manteniendo el encapsulamiento del dominio.

---

# ¿Qué aprendí?

Actualizar un objeto no significa crear uno nuevo.

Primero es necesario localizar el objeto que ya existe y después modificar directamente su estado.

En este sprint entendí que la actualización se realiza sobre el mismo objeto almacenado dentro del equipo del entrenador.

---

# Flujo de actualización

La operación quedó organizada de la siguiente manera.

```text
Buscar entrenador

↓

Buscar Pokémon

↓

Validar reglas

↓

Modificar atributos

↓

Guardar cambios
```

Cada paso es responsabilidad de una clase diferente.

---

# Responsabilidades

## Aplicacion

Coordina el flujo de la edición.

Solicita los nuevos datos al usuario y llama a los métodos correspondientes.

---

## Entrenador

Busca el Pokémon dentro del equipo.

Valida reglas relacionadas con toda la colección.

Ejemplo:

- nombre duplicado.

---

## Pokemon

Modifica sus propios atributos.

Ejemplo:

- cambiarNombre()
- cambiarTipo()
- cambiarNivel()

---

# Validaciones

No todas las validaciones pertenecen a la misma clase.

Las reglas relacionadas únicamente con un Pokémon pertenecen a Pokemon.

Las reglas que comparan un Pokémon con el resto del equipo pertenecen a Entrenador.

---

# Referencias

El método de búsqueda devuelve una referencia al Pokémon encontrado.

Gracias a esa referencia fue posible modificar directamente el objeto existente sin eliminarlo del ArrayList ni volver a agregarlo.

---

# Beneficios

Esta organización permitió:

- reutilizar métodos ya existentes;
- mantener el encapsulamiento;
- evitar duplicación de código;
- conservar una única responsabilidad por clase.

---

# Lo que entendí

Actualizar un objeto consiste en modificar el estado de una instancia que ya existe.

No es necesario crear un nuevo objeto cuando ya se posee una referencia al que se desea modificar.

Cada clase continúa siendo responsable únicamente de la información que le pertenece.