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
