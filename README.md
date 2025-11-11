# Trabajo-Programaci-n-Funcional
Este proyecto pone en práctica los conceptos fundamentales de la programación funcional en Java, utilizando Streams, Lambdas y Collectors.
A través de ejemplos sencillos y bien estructurados, se muestran distintas operaciones aplicadas a colecciones de datos en dominios variados: alumnos, productos, libros y empleados.

REQUISITOS DEL ENTORNO

* Java JDK 8 o superior (recomendado: JDK 17)
* Un entorno de desarrollo como IntelliJ IDEA

Ejecución:

1. Compilar las clases del proyecto:
   javac Main.java
2. Ejecutar la aplicación principal:
   java Main
3. Se mostrarán los resultados de cada ejercicio en consola.


EJERCICIOS INCLUIDOS

1. ALUMNOS
   Ejemplo educativo con una lista de estudiantes.

* Filtrar aprobados (nota mayor o igual a 7) y mostrar nombres en mayúsculas.
* Calcular el promedio general de todas las notas.
* Agrupar por curso con groupingBy().
* Mostrar los tres mejores promedios ordenados de mayor a menor.

Funciones clave utilizadas: filter, map, sorted, collect, groupingBy, averagingDouble, limit.

2. PRODUCTOS
   Gestión de productos y análisis de stock.

* Filtra productos con precio mayor a 100.
* Agrupa por categoría y suma el stock total.
* Combina nombre y precio en una cadena formateada con joining(" | ").
* Calcula el precio promedio total y el promedio por categoría.

Funciones clave utilizadas: filter, sorted, groupingBy, summingInt, joining, averagingDouble.

3. LIBROS
   Explora colecciones de libros con distintas métricas.

* Muestra los títulos con más de 300 páginas.
* Calcula el promedio de páginas.
* Agrupa libros por autor y los cuenta.
* Identifica el libro más caro usando max().

Funciones clave utilizadas: filter, map, sorted, groupingBy, counting, max.

4. EMPLEADOS
   Datos laborales aplicados a Streams.

* Lista empleados con salario superior a 2000.
* Calcula el salario promedio general.
* Agrupa por departamento sumando sueldos.
* Muestra los dos empleados más jóvenes.

Funciones clave utilizadas: filter, sorted, groupingBy, summingDouble, averagingDouble, limit.

RESUMEN FINAL

Este trabajo no solo busca aplicar la API de Streams, sino comprender el paradigma funcional dentro del ecosistema Java.
Mediante estas prácticas, se promueve un estilo de programación más limpio, expresivo y mantenible, donde el foco está en qué se quiere lograr, no en cómo hacerlo paso a paso.

En conclusión, dominar el uso de Streams y funciones Lambda permite escribir código moderno, eficiente y alineado con las tendencias actuales del desarrollo en Java.
