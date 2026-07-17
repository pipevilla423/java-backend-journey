# Sprint 2 - Registro de entrenadores

## ¿Qué construí?

Implementé el registro de entrenadores desde la consola. Creé la clase `GestorEntrenadores` para administrar la colección de entrenadores, permitiendo registrarlos y mostrarlos posteriormente. Además, separé las responsabilidades entre las diferentes clases para que cada una cumpliera un propósito específico dentro de la aplicación.

## ¿Qué conceptos de Java aprendí?

- Separación de responsabilidades.
- Organización del código en múltiples clases.
- Uso de `Scanner` para obtener datos desde la consola.
- Ciclos `while`.
- Métodos con responsabilidades específicas.
- Reutilización de código.
- Encapsulamiento aplicado a la administración de colecciones.

## ¿Qué decisiones de diseño tomé y por qué?

Decidí crear la clase `GestorEntrenadores` para centralizar la administración de los entrenadores y evitar que `Main` manipulara directamente el `ArrayList`.

Renombré el método `crearEntrenador()` por `registrarEntrenador()`, ya que el método no solo crea un objeto, sino que también lo almacena dentro del gestor, representando mejor su verdadera responsabilidad.

También decidí que `Main` únicamente coordinara el flujo del programa, mientras que `GestorEntrenadores` se encargara de administrar los entrenadores.

## ¿Qué dificultades tuve y cómo las resolví?

Al principio tuve dudas sobre dónde debía ubicarse la lógica para registrar un entrenador. Consideré implementarla dentro de la clase `Entrenador`, pero comprendí que esa responsabilidad pertenecía al `GestorEntrenadores`.

También tuve dudas sobre cómo permitir el registro de múltiples entrenadores sin implementar todavía un menú de opciones. Finalmente resolví el problema utilizando un ciclo `while` que repite el proceso mientras el usuario desee seguir registrando entrenadores.

Además, surgió la duda de si el gestor debía depender de la consola. Comprendí que la obtención de los datos pertenece al flujo del programa (`Main`), mientras que el gestor únicamente debe encargarse de administrarlos.

## ¿Qué mejoraría si tuviera que refactorizar este sprint?

Separaría aún más la lógica de entrada de datos para que `GestorEntrenadores` no dependa de la consola y pueda reutilizarse fácilmente si en el futuro los datos provienen de una API, una interfaz gráfica o un archivo.

También implementaría validaciones para controlar entradas inválidas durante el registro de entrenadores y mejorar la experiencia del usuario.