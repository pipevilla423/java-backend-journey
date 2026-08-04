# Abstracción de la consola

# ¿Qué significa abstraer la consola?

Significa ocultar los detalles de cómo se leen y muestran los datos.

En lugar de escribir directamente:

```java
System.out.println(...);

scanner.nextLine();
```

el resto del programa utiliza métodos con mayor nivel de abstracción.

Ejemplo:

```java
pedirTexto(...)

pedirEntero(...)

pedirDecision(...)

imprimirMensaje(...)
```

---

# ¿Qué problema resuelve?

El resto del programa deja de depender de Scanner.

Solo conoce métodos que expresan una intención.

Por ejemplo:

```java
String nombre = consola.pedirTexto(...);
```

No importa cómo obtiene realmente ese texto.

---

# Reutilización

Muchos datos diferentes comparten el mismo comportamiento.

Ejemplo:

- nombre del entrenador
- región
- nombre del Pokémon
- tipo

Todos son String.

Por esa razón basta con un único método:

```java
pedirTexto(String mensaje)
```

Lo único que cambia es el mensaje mostrado al usuario.

---

# Entrada y salida

La abstracción no solo aplica para leer información.

También aplica para mostrarla.

Por esa razón existe un método como:

```java
imprimirMensaje(...)
```

Si mañana cambia la forma de mostrar información, únicamente será necesario modificar ese método.

---

# Uso de un recurso compartido

AdministradorTexto posee un único atributo.

```java
private final Scanner scanner;
```

Todos los métodos utilizan ese mismo objeto.

Esto evita crear múltiples Scanner y centraliza completamente la entrada de datos.

---

# Preparación para el futuro

Hoy el programa utiliza consola.

Mañana podría utilizar una interfaz gráfica o una aplicación web.

Las clases del dominio continuarían funcionando igual porque no conocen Scanner.

Solo conocen datos como:

- String
- int
- boolean

La implementación encargada de obtener esos datos podría cambiar sin afectar la lógica del negocio.

---

# Lo que aprendí

Abstraer no significa ocultar código por comodidad.

Significa ocultar los detalles de implementación para que el resto del programa trabaje únicamente con operaciones de alto nivel.

Gracias a esta abstracción, el proyecto quedó mejor preparado para futuras modificaciones sin afectar las clases del dominio.