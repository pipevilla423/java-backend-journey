# Orquestación de una aplicación

# ¿Qué significa orquestar?

Orquestar significa coordinar distintas partes de un sistema para que trabajen juntas.

La clase que orquesta no implementa todas las reglas.

Simplemente organiza el flujo de ejecución.

---

# Aplicacion como orquestador

En este proyecto la clase Aplicacion es el orquestador.

Su responsabilidad consiste en decidir:

- qué operación ejecutar;
- cuándo ejecutarla;
- en qué orden ejecutarla.

No contiene reglas del negocio.

---

# Relación con las demás clases

Aplicacion reutiliza otras clases especializadas.

```text
Aplicacion

↓

AdministradorTexto

↓

GestorEntrenadores

↓

Entrenador

↓

ArchivoEntrenadores
```

Cada una mantiene su responsabilidad.

Aplicacion únicamente coordina su utilización.

---

# Estado compartido

Aplicacion posee los objetos principales como atributos.

```java
private final GestorEntrenadores gestor;

private final AdministradorTexto consola;

private final ArchivoEntrenadores archivo;
```

Todos los métodos trabajan sobre esos mismos objetos.

Esto evita pasarlos constantemente como parámetros o retornarlos entre operaciones.

---

# ¿Qué ocurre cuando aparece una nueva funcionalidad?

La primera pregunta no debería ser:

> ¿Dónde pongo el código?

La primera pregunta debe ser:

> ¿Qué clase es responsable de esta nueva regla del negocio?

Una vez implementada esa regla en la clase correspondiente, Aplicacion únicamente la incorpora al flujo del programa.

---

# Beneficios

## Flujo claro

El funcionamiento general de la aplicación puede comprenderse leyendo únicamente el método iniciar().

---

## Responsabilidades separadas

Cada clase continúa haciendo únicamente el trabajo que le corresponde.

---

## Escalabilidad

Agregar nuevas operaciones resulta mucho más sencillo porque la arquitectura ya define quién coordina y quién implementa cada responsabilidad.

---

# Lo que aprendí

Una clase orquestadora no sustituye a las demás clases.

Su función consiste en coordinar el trabajo de componentes especializados, manteniendo separadas las responsabilidades y construyendo el flujo completo de la aplicación.