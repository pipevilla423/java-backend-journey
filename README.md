#  Mis Apuntes de Java

arquitectura de 3 capas que permite que java funcione en cualquier dispositivo

* **jvm** = java virtual machine es el traductor de los archivos .class a los sistemas operativos 
* **jre** = java runing enviroment contiene el jvm y los recursos necesarios para que ejecute en cualquier dispositivo
* **jdk** = contiene el jre, compilador, etc es el kit completo de desarrollo en java 

## ciclo de vida:
1. escribo codigo
2. el jdk con la herramienta compilador javac traduce este codigo a un archivo .class
3. jre da los recursos para que el programa lo soporte cualquier dispositivo
4. traduce estos archivos .class al sistema operativo

# Pilares de la POO (Programación Orientada a Objetos)

* **abstraccion** = simplificar un objeto de la realidad dejando solo los atributos y metodos necesarios para el sistema (ej: de un pokemon solo me importa su hp, nombre y tipo).
* **encapsulamiento** = ocultar y proteger los datos de un objeto definiendo que es publico y que es privado.
* **herencia** = reutilizar codigo haciendo que clases hijas hereden atributos y metodos de una clase padre.
* **polimorfismo** = un mismo metodo o comportamiento actua de formas diferentes segun el objeto hijo que lo ejecute (muchas formas).

# Clases

## ¿Qué es una clase?

Una clase es una plantilla o modelo que define la **estructura** y el **comportamiento** de un tipo de objeto. A partir de una clase se pueden crear múltiples objetos que compartirán las mismas características y acciones, aunque cada uno tendrá sus propios valores.

## ¿Para qué sirve una clase?

Una clase sirve para representar entidades del dominio del problema y establecer cómo serán los objetos que se crearán a partir de ella.

## ¿Qué puede contener una clase?

Una clase puede contener:

- **Atributos:** representan las características o el estado del objeto.
- **Métodos:** representan las acciones o comportamientos que el objeto puede realizar.
- **Constructores:** se utilizan para inicializar el objeto cuando se crea.

### Ejemplo del proyecto

En este proyecto se creó la clase `Pokemon`, que define que todo Pokémon tendrá atributos como nombre, tipo y nivel, además de métodos para consultar o mostrar su información.

A partir de esta clase se pueden crear muchos objetos diferentes, por ejemplo:

- Mudkip
- Lucario
- Charmander

Todos pertenecen a la misma clase, pero cada uno posee valores distintos en sus atributos.

# Objetos

## ¿Qué es un objeto?

Un objeto es una **instancia de una clase**. Es la representación concreta de la plantilla definida por la clase, donde cada atributo ya posee un valor específico.

## ¿Qué relación tiene un objeto con una clase?

La clase define cómo serán los objetos, mientras que el objeto es la materialización de esa definición.

Una misma clase puede utilizarse para crear múltiples objetos con diferentes valores en sus atributos.

## Diferencia entre una clase y un objeto

La clase `Pokemon` únicamente define la estructura de un Pokémon, indicando que tendrá atributos como nombre, tipo y nivel.

Un objeto, por ejemplo `pikachu`, representa un Pokémon específico cuyos atributos ya tienen valores asignados.

Ejemplo:

Clase:

- `Pokemon`

Objetos creados a partir de ella:

- `pikachu`
- `charizard`
- `gengar`

Todos pertenecen a la misma clase, pero cada uno almacena información diferente.

---

### Relación con el proyecto

En este proyecto, los objetos creados se utilizan posteriormente dentro de otras clases, como `Main` o `Entrenador`, para construir el funcionamiento del sistema.

# Encapsulamiento

## ¿Qué es el encapsulamiento?

El encapsulamiento consiste en proteger el estado interno de un objeto y controlar la forma en que otras partes del programa pueden acceder o modificar sus atributos.

## ¿Por qué usamos `private`?

Usamos `private` para evitar que los atributos de una clase puedan modificarse libremente desde cualquier parte del programa.

De esta manera, la propia clase mantiene el control sobre su información.

## ¿Qué problema evita?

El encapsulamiento ayuda a evitar modificaciones incorrectas o inconsistentes en los objetos.

Por ejemplo, si el nivel de un Pokémon se pudiera modificar directamente, cualquier parte del programa podría asignarle un valor inválido. Al mantener el atributo privado, podemos obligar a que los cambios pasen por un método que aplique las validaciones necesarias.

## Uso de setters

Los setters permiten modificar atributos privados de forma controlada.

Sin embargo, un setter no garantiza por sí mismo que el dato sea válido. Para proteger realmente el objeto, el método debe verificar el valor antes de asignarlo.

Por ejemplo, un setter de nivel podría comprobar que el número esté dentro de un rango permitido.

## Uso de getters

Los getters permiten consultar el valor de un atributo privado sin necesidad de convertirlo en `public`.

Esto permite mantener el encapsulamiento y decidir qué información puede ser consultada desde otras clases.

## Idea principal

- `private` protege el acceso directo.
- Los getters permiten consultar información.
- Los setters permiten modificar información.
- Las validaciones dentro de los métodos ayudan a conservar un estado válido.

---

### Relación con el proyecto

En las clases `Pokemon` y `Entrenador`, los atributos se declararon como privados para evitar que otras clases los modifiquen directamente.

El acceso a esos datos se realiza mediante getters y, cuando sea necesario modificar un valor, deberá hacerse mediante métodos que controlen esa operación.

# Constructores

## ¿Qué es un constructor?

Un constructor es un miembro especial de una clase cuya función es inicializar un objeto cuando este se crea.

Su objetivo es asignar los valores iniciales a los atributos para que el objeto nazca en un estado válido.

## ¿Cuándo se ejecuta?

El constructor se ejecuta automáticamente cuando se crea un objeto utilizando la palabra reservada `new`.

Ejemplo conceptual:

- Se crea un objeto.
- Java llama al constructor.
- El constructor inicializa los atributos.
- El objeto queda listo para utilizarse.

## ¿Para qué sirve `this`?

La palabra reservada `this` hace referencia al objeto actual.

Dentro del constructor se utiliza para diferenciar los atributos de la clase de los parámetros recibidos cuando ambos tienen el mismo nombre.

Ejemplo conceptual:

```java
this.nombre = nombre;
```

- `this.nombre` → atributo del objeto.
- `nombre` → parámetro recibido por el constructor.

## Inicialización de colecciones

Cuando un objeto contiene un `ArrayList`, este debe inicializarse antes de poder utilizarse.

Por eso, en la clase `Entrenador`, el equipo se inicializa dentro del constructor.

Si no se crea el `ArrayList`, el atributo tendrá el valor `null` y cualquier intento de agregar elementos producirá un error.

---

### Relación con el proyecto

En este proyecto, cada vez que se crea un `Entrenador`, su constructor inicializa automáticamente el equipo como un `ArrayList` vacío para que posteriormente puedan agregarse objetos `Pokemon`.

# Métodos

## ¿Qué es un método?

Un método representa un comportamiento o una acción que puede realizar un objeto.

Los métodos utilizan los atributos del objeto y aplican lógica para ejecutar un proceso específico.

## ¿Para qué sirven?

Los métodos permiten que una clase realice operaciones relacionadas con su propia información.

Gracias a ellos, la lógica del programa queda organizada dentro de las clases correspondientes.

## Diferencia entre un atributo y un método

Los atributos representan el estado o las características del objeto.

Los métodos representan las acciones o comportamientos que ese objeto puede realizar utilizando sus atributos.

Ejemplo:

Clase `Pokemon`

Atributos:

- nombre
- tipo
- nivel

Métodos:

- subirNivel()
- atacar()
- evolucionar()

## ¿Por qué crear `agregarPokemon()`?

En lugar de modificar directamente el `ArrayList` desde `Main`, se creó el método `agregarPokemon()` para que el propio objeto `Entrenador` sea el responsable de administrar su equipo.

De esta manera, en el futuro será posible agregar validaciones o reglas de negocio sin modificar el resto del programa.

## Ventajas de guardar la lógica dentro de la clase

- El código resulta más organizado.
- La lógica relacionada con un objeto se encuentra en un único lugar.
- Facilita el mantenimiento del sistema.
- Permite agregar validaciones sin modificar otras partes del programa.
- Hace que el proyecto sea más escalable conforme aumenta su tamaño.

---

### Relación con el proyecto

En este proyecto, la responsabilidad de agregar Pokémon pertenece a la clase `Entrenador`, ya que es ella quien conoce y administra su propio equipo.

# ArrayList

## ¿Qué es un ArrayList?

Un `ArrayList` es una estructura de datos dinámica que permite almacenar múltiples elementos del mismo tipo.

A diferencia de un arreglo tradicional, no es necesario definir su tamaño al momento de crearlo, ya que puede crecer o disminuir durante la ejecución del programa.

## Diferencia entre una variable y un ArrayList

Una variable almacena un único valor u objeto.

Un `ArrayList` almacena múltiples elementos del mismo tipo, permitiendo recorrerlos, agregarlos o eliminarlos cuando sea necesario.

## ¿Qué significa `ArrayList<Pokemon>`?

Significa que la colección únicamente puede almacenar objetos de tipo `Pokemon`.

El tipo indicado entre los símbolos `< >` determina qué clase de elementos puede contener la colección.

## ¿Por qué utilizar un ArrayList?

Se eligió un `ArrayList` porque el número de Pokémon que tendrá un entrenador puede cambiar con el tiempo.

Si en lugar de una colección se utilizaran atributos como:

- pokemon1
- pokemon2
- pokemon3

cada vez que se quisiera aumentar el tamaño del equipo habría que modificar la estructura de la clase.

Con un `ArrayList` simplemente se agregan nuevos objetos a la colección.

## Conceptos aprendidos

Durante este sprint se aprendió que:

- Los elementos se agregan utilizando el método `add()`.
- Un `ArrayList` debe inicializarse antes de utilizarse.
- Si no se inicializa (por ejemplo, dentro del constructor), su valor será `null` y cualquier operación sobre él producirá un error.

---

### Relación con el proyecto

Cada objeto `Entrenador` posee un `ArrayList<Pokemon>` llamado `equipo`, donde se almacenan todos los Pokémon pertenecientes a ese entrenador.

# Getters

## ¿Qué es un getter?

Un getter es un método que permite consultar el valor de un atributo privado sin necesidad de convertir dicho atributo en `public`.

## ¿Para qué sirve?

Los getters permiten acceder a la información de un objeto de forma controlada, manteniendo el encapsulamiento de la clase.

Gracias a ellos, otras clases pueden consultar información sin modificar directamente los atributos.

## ¿Por qué no utilizar atributos públicos?

Si los atributos fueran públicos, cualquier parte del programa podría acceder y modificar la información sin ningún tipo de control.

Al utilizar atributos privados y getters, la clase mantiene el control sobre su propio estado.

## ¿Cuándo utilizar un getter?

Un getter se utiliza cuando simplemente se necesita conocer el valor actual de un atributo.

Ejemplo:

- Consultar el nombre de un Pokémon.
- Consultar el nivel de un entrenador.

## ¿Cuándo crear un método específico?

Cuando la información requiere aplicar lógica o representar una operación del objeto, es preferible crear un método específico.

Por ejemplo:

- `agregarPokemon()`
- `cantidadPokemon()`
- `subirNivel()`

De esta manera, la lógica permanece dentro de la clase y el resto del programa solo interactúa con ella mediante comportamientos bien definidos.

---

### Relación con el proyecto

En este proyecto se utilizaron getters para consultar la información de los objetos y métodos específicos, como `agregarPokemon()`, para modificar el estado del entrenador de forma controlada.

# toString()

## ¿Qué es `toString()`?

`toString()` es un método heredado de la clase `Object` que devuelve una representación en texto de un objeto.

## ¿Por qué sobrescribir (`@Override`) este método?

Se sobrescribe porque la implementación por defecto no muestra la información del objeto de forma útil.

Al utilizar `@Override`, indicamos que queremos reemplazar el comportamiento heredado con una representación personalizada.

## ¿Qué ocurre si no se sobrescribe?

Si un objeto no tiene un `toString()` sobrescrito, Java utilizará la implementación de la clase `Object`.

Normalmente se mostrará el nombre de la clase junto con una representación hexadecimal del objeto, en lugar de sus atributos.

Ejemplo:

```text
Pokemon@3feba861
```

## Ventajas de utilizar `toString()`

Sobrescribir este método permite visualizar la información del objeto de forma clara y legible.

Esto facilita las pruebas, la depuración y la comprensión del estado de los objetos durante el desarrollo.

---

### Relación con el proyecto

En este proyecto se sobrescribió `toString()` para mostrar los datos de `Pokemon` y `Entrenador` de forma organizada al imprimir los objetos por consola.
