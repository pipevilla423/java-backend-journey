# docs/sprints/Sprint-06.md

# Sprint 06 - Persistencia con archivos

## Objetivo

Hasta el Sprint 5 toda la información existía únicamente mientras el programa estaba ejecutándose.

Al cerrar la aplicación, todos los entrenadores registrados desaparecían porque únicamente estaban almacenados en memoria RAM.

El objetivo de este sprint fue lograr que los datos permanecieran entre ejecuciones utilizando archivos de texto.

---

# ¿Qué aprendí?

Aprendí que un objeto existe únicamente mientras el proceso de Java está en ejecución.

Aunque un `ArrayList` almacene todos los entrenadores, este también vive en memoria RAM. Cuando el programa termina, el sistema operativo libera esa memoria y todos los objetos desaparecen.

Para conservar la información es necesario transformarla a un medio de almacenamiento permanente, como un archivo.

---

# Arquitectura

Durante este sprint apareció una nueva responsabilidad.

Antes:

Main
↓
GestorEntrenadores

Ahora:

Main
↓
GestorEntrenadores
↓
ArchivoEntrenadores

Cada clase tiene una responsabilidad diferente.

## Main

Coordina la aplicación.

- inicia el programa
- carga los entrenadores
- ejecuta el menú
- guarda la información

No sabe leer archivos.

---

## GestorEntrenadores

Administra objetos.

Su responsabilidad continúa siendo:

- registrar entrenadores
- buscarlos
- mantener la colección

No conoce archivos.

---

## ArchivoEntrenadores

Su responsabilidad es la persistencia.

Se encarga de:

- leer archivos
- escribir archivos
- convertir texto en objetos
- convertir objetos en texto

No administra entrenadores.

---

# Flujo del programa

Inicio

↓

leer archivo

↓

crear objetos Entrenador

↓

cargar GestorEntrenadores

↓

usuario trabaja normalmente

↓

guardar colección

↓

fin

---

# Decisiones importantes

## Crear una clase independiente

No colocamos la lógica de lectura dentro del gestor porque habría tenido dos responsabilidades distintas.

El gestor administra entrenadores.

ArchivoEntrenadores administra la persistencia.

---

## Devolver una colección

El método:

```java
cargarEntrenadores()
```

retorna un:

```java
ArrayList<Entrenador>
```

porque el archivo representa toda la colección y no un único entrenador.

De esta manera toda la lógica de lectura queda encapsulada dentro de la clase responsable.

---

## Guardar toda la colección

El método:

```java
guardarEntrenadores(ArrayList<Entrenador>)
```

recibe toda la colección porque el archivo debe representar el estado actual del programa.

No solamente el último entrenador agregado.

---

## Ruta inmutable

```java
private final String rutaArchivo;
```

La ruta nunca cambia durante la vida del objeto.

Hacerla `final` expresa esa intención y evita modificaciones accidentales.

---

# Dificultades

Durante el desarrollo apareció un problema donde el archivo parecía sobrescribirse incorrectamente.

Después de revisar el flujo de lectura y escritura se encontró el error y quedó claro cómo funciona la actualización completa del archivo.

---

# Lo que entendí

Persistir información no significa guardar objetos.

Significa transformar objetos en un formato que pueda almacenarse y posteriormente reconstruir esos objetos cuando el programa vuelva a iniciar.

---

# Resultado

Ahora la aplicación conserva los entrenadores entre ejecuciones.

La lógica del negocio continúa separada de la persistencia, lo que permitirá reemplazar el archivo de texto por otro mecanismo de almacenamiento en el futuro sin modificar el gestor.