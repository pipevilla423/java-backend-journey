# docs/teoria/11-persistencia-y-archivos.md

# Persistencia y archivos

## ¿Qué es la persistencia?

Persistencia es la capacidad de conservar información incluso después de cerrar el programa.

Sin persistencia:

```
Programa inicia

↓

Crear objetos

↓

Cerrar programa

↓

Objetos perdidos
```

Con persistencia:

```
Programa inicia

↓

Leer archivo

↓

Crear objetos

↓

Trabajar

↓

Guardar archivo

↓

Cerrar programa
```

---

# ¿Por qué se pierden los objetos?

Los objetos viven en memoria RAM.

Cuando el proceso de Java termina, la memoria utilizada por el programa es liberada.

Como consecuencia desaparecen:

- variables
- ArrayList
- objetos
- referencias

---

# Transformación de objetos

Los archivos de texto no entienden objetos.

Por eso primero deben transformarse en texto.

```
Objeto

↓

Texto

↓

Archivo
```

Cuando el programa inicia ocurre el proceso inverso.

```
Archivo

↓

Texto

↓

Objeto
```

---

# ¿Por qué usar un separador?

Se eligió:

```
;
```

Ejemplo:

```
Pipe;Kanto
```

Después de ejecutar:

```java
linea.split(";");
```

se obtiene:

```java
["Pipe", "Kanto"]
```

Con esas posiciones pueden reconstruirse los atributos del objeto.

```java
new Entrenador(datos[0], datos[1]);
```

---

# ¿Por qué cargar devuelve una lista?

Porque el archivo representa una colección completa.

El método lee todas las líneas, reconstruye todos los entrenadores y devuelve una colección lista para usar.

---

# ¿Por qué guardar recibe la colección?

Porque el archivo debe quedar sincronizado con el estado actual del gestor.

No solamente con el último entrenador creado.

---

# Beneficio del diseño

Si mañana se reemplaza el archivo por MySQL, únicamente cambiaría la clase encargada de la persistencia.

El resto del programa prácticamente permanecería igual porque la lógica del negocio está desacoplada del almacenamiento.