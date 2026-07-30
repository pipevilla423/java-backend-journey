# docs/teoria/12-bufferedreader-bufferedwriter.md

# BufferedReader y BufferedWriter

## FileReader

Su función es abrir un archivo para lectura.

No proporciona métodos cómodos para leer línea por línea.

---

## BufferedReader

Envuelve un FileReader y agrega funcionalidades.

La más importante:

```java
readLine()
```

Permite leer una línea completa del archivo.

---

## ¿Qué devuelve readLine()?

Mientras existan líneas:

```text
Pipe;Kanto
```

```text
Ash;Johto
```

devuelve un String.

Cuando no existen más líneas devuelve:

```java
null
```

No devuelve una cadena vacía.

Esto permite distinguir entre:

- una línea vacía existente
- el final del archivo

---

## BufferedWriter

Permite escribir texto en un archivo.

Los métodos utilizados fueron:

```java
write()
```

Escribe texto.

```java
newLine()
```

Agrega un salto de línea.

---

## FileWriter

Es el encargado de abrir el archivo para escritura.

BufferedWriter trabaja sobre él para facilitar la escritura.

---

# Flujo de lectura

Archivo

↓

FileReader

↓

BufferedReader

↓

readLine()

↓

split(";")

↓

Objeto

---

# Flujo de escritura

Objeto

↓

Texto

↓

BufferedWriter

↓

FileWriter

↓

Archivo

---

# IOException

Las operaciones sobre archivos pueden fallar.

Por ejemplo:

- archivo inexistente
- permisos insuficientes
- errores de lectura

Por eso los métodos declaran:

```java
throws IOException
```

En este sprint únicamente se propagó la excepción.

Su manejo mediante `try-catch` se estudiará posteriormente.