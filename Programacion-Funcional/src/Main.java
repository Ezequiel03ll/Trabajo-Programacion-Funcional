import entidades.Alumno;
import entidades.Empleado;
import entidades.Libro;
import entidades.Producto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class Main {

    public static void main(String[] args) {

        System.out.println("--- Ejecución de Ejercicios Java Streams (Ejemplos Actualizados) ---");


        System.out.println("\n\n Ejercicio Practico 1 -> ALUMNOS ");
        // Definición de la lista de alumnos (datos modificados)
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Camila", 18, 7.8, "Introducción a Java"),
                new Alumno("Diego", 24, 6.4, "Redes y Comunicaciones"),
                new Alumno("Valeria", 20, 9.3, "Desarrollo Web"),
                new Alumno("Martín", 22, 5.9, "Bases de Datos"),
                new Alumno("Lucía", 21, 8.1, "Ingeniería de Software"),
                new Alumno("Federico", 19, 7.0, "Programación Concurrente")
        );

        // 1. Nombres aprobados (nota >= 7) en mayúsculas y ordenados
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(toList());
        System.out.println("\n  Nombres de alumnos aprobados: " + aprobados);

        // 2. Promedio general de notas
        double promedioGeneral = alumnos.stream()
                .collect(averagingDouble(Alumno::getNota));
        System.out.printf(" Promedio general de notas: %.2f\n", promedioGeneral);

        // 3. Agrupar por curso
        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(groupingBy(Alumno::getCurso));
        System.out.println("\n Alumnos agrupados por Curso:");
        porCurso.forEach((curso, lista) -> System.out.println(" - " + curso + " (" + lista.size() + ")"));

        // 4. 3 mejores promedios
        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .collect(toList());
        System.out.println("\n Top 3 alumnos con mejores notas: " + top3);


        System.out.println("\n\n Ejercicio Practico 2 -> PRODUCTOS ");
        // Definición de la lista de productos (datos modificados)
        List<Producto> productos = Arrays.asList(
                new Producto("Auriculares inalámbricos", "Electrónica", 89.99, 60),
                new Producto("Teclado mecánico", "Electrónica", 129.50, 25),
                new Producto("Estantería modular", "Muebles", 199.00, 12),
                new Producto("Silla ergonómica", "Muebles", 349.90, 8),
                new Producto("Set de cocina 10pcs", "Hogar", 75.00, 40),
                new Producto("Lámpara de escritorio LED", "Decoración", 45.00, 55)
        );

        //  Precio > 100, ordenados descendentemente
        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(toList());
        System.out.println("\n  Productos caros (> $100) ordenados:");
        caros.forEach(System.out::println);

        // Agrupar por categoría y sumar stock
        Map<String, Integer> stockPorCat = productos.stream()
                .collect(groupingBy(Producto::getCategoria, summingInt(Producto::getStock)));
        System.out.println("\n Stock total por categoría: " + stockPorCat);

        // Generar String con nombre y precio separados por ' | '
        String listaProductos = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining(" | "));
        System.out.println("\n Lista de productos (Nombre $Precio): " + listaProductos);

        // Precio promedio general
        double promGeneralPrecio = productos.stream()
                .collect(averagingDouble(Producto::getPrecio));
        System.out.printf("\n  Precio promedio general: %.2f\n", promGeneralPrecio);

        // Precio promedio por categoría
        Map<String, Double> promPorCat = productos.stream()
                .collect(groupingBy(Producto::getCategoria, averagingDouble(Producto::getPrecio)));
        System.out.println("\n Promedio por categoría: " + promPorCat);


        System.out.println("\n\n   Ejercicio Practico 3 -> LIBROS ");
        // Definición de la lista de libros (datos modificados)
        List<Libro> libros = Arrays.asList(
                new Libro("Viaje al centro del código", "A. Gómez", 320, 78.50),
                new Libro("Algoritmos para la vida", "R. Fernández", 220, 59.90),
                new Libro("Historias del servidor", "M. Ortega", 410, 125.00),
                new Libro("Pequeñas grandes bases", "L. Núñez", 160, 39.99),
                new Libro("Arquitectura moderna", "P. Salas", 520, 210.00)
        );

        // Títulos con más de 300 páginas, ordenados alfabéticamente
        List<String> largos = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(toList());
        System.out.println("\n Títulos de libros >300 páginas: " + largos);

        // Promedio de páginas
        double promPaginas = libros.stream()
                .collect(averagingInt(Libro::getPaginas));
        System.out.printf("\n Promedio de páginas: %.2f\n", promPaginas);

        // Agrupar por autor y contar libros
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(groupingBy(Libro::getAutor, counting()));
        System.out.println("\n Conteo de libros por autor: " + librosPorAutor);

        // libro mas costoso
        System.out.print("\n Libro más costoso: ");
        libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio))
                .ifPresent(System.out::println);



        System.out.println("\n\n   Ejercicio Practico 4 -> EMPLEADOS ");
        // Definición de la lista de empleados (datos modificados)
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Raúl", 34, "Soporte", 1850.00),
                new Empleado("Mariana", 29, "Desarrollo", 3750.50),
                new Empleado("Sebastián", 26, "Marketing", 2400.00),
                new Empleado("Noelia", 31, "Desarrollo", 4100.00),
                new Empleado("Gonzalo", 23, "Operaciones", 1950.75)
        );

        // Salario > 2000, ordenado descendente
        List<Empleado> bienPagados = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(toList());
        System.out.println("\nEmpleados con salario > $2000:");
        bienPagados.forEach(System.out::println);

        // Salario promedio general
        double promSalario = empleados.stream()
                .collect(averagingDouble(Empleado::getSalario));
        System.out.printf("\nSalario promedio general: %.2f\n", promSalario);

        // Agrupar por departamento y sumar salarios
        Map<String, Double> totalSalarioDepto = empleados.stream()
                .collect(groupingBy(Empleado::getDepartamento, summingDouble(Empleado::getSalario)));
        System.out.println("\nTotal salarios por departamento: " + totalSalarioDepto);

        // Nombres de los 2 empleados más jóvenes
        List<String> jovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(toList());
        System.out.println("\n 2 empleados más jóvenes: " + jovenes);

        System.out.println("\n--------------------------------------------------------------");
    }
}
