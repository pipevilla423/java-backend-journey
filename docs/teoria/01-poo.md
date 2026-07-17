# Programación Orientada a Objetos (POO)

## ¿Qué es una clase?

Una clase es un molde o plantilla que define la estructura y el comportamiento que tendrán los objetos.

Una clase contiene:

- atributos;
- métodos;
- constructores.

Ejemplo:

```java
public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;

}
```

---

## ¿Qué es un objeto?

Un objeto es una instancia de una clase.

Mientras la clase define cómo será un objeto, el objeto representa un elemento real creado a partir de esa definición.

Ejemplo:

```java
Pokemon pikachu = new Pokemon("Pikachu","Eléctrico",20);
```

---

## Encapsulamiento

Consiste en proteger los atributos de una clase para evitar modificaciones directas desde el exterior.

Para ello se utilizan:

- atributos `private`;
- getters;
- setters cuando son necesarios.

Beneficios:

- protege la información;
- controla modificaciones;
- facilita el mantenimiento.

---

## Constructores

El constructor inicializa un objeto cuando este es creado.

Ejemplo:

```java
public Pokemon(String nombre, String tipo, int nivel){
    this.nombre = nombre;
    this.tipo = tipo;
    this.nivel = nivel;
}
```

---

## Métodos

Los métodos representan el comportamiento de un objeto.

Ejemplo:

```java
agregarPokemon()
```

Los métodos permiten encapsular lógica dentro de la clase responsable.

---

## toString()

Sobrescribe la representación textual de un objeto.

Permite imprimir información legible en lugar de la referencia en memoria.

Ejemplo:

```java
System.out.println(pokemon);
```

