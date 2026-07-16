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
