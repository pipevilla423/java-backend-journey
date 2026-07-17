# Colecciones

## ArrayList

Es una colección dinámica que permite almacenar múltiples objetos del mismo tipo.

Ejemplo:

```java
private ArrayList<Pokemon> equipo;
```

---

## Declaración

```java
private ArrayList<Tipo> lista;
```

---

## Inicialización

```java
this.lista = new ArrayList<>();
```

Debe realizarse normalmente en el constructor.

---

## Agregar elementos

```java
lista.add(elemento);
```

En el proyecto:

```java
agregarPokemon(Pokemon pokemon)
```

---

## Getter de una colección

```java
public ArrayList<Pokemon> getEquipo(){
    return equipo;
}
```

Permite consultar la colección desde otras clases.

Más adelante aprenderemos formas de proteger la colección de modificaciones externas.

---

## Flujo

1. Se crea el objeto.
2. Se inicializa el ArrayList.
3. Se agregan elementos.
4. Se consulta mediante un getter.