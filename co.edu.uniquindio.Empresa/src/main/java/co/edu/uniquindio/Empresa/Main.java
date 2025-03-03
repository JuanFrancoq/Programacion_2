package co.edu.uniquindio.Empresa;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Departamento desarrollo = new Departamento("Desarrollo", "D001");

        Gerente gerente1 = new Gerente("Ana López", 1004870686, desarrollo);
        Tecnico tecnico1 = new Tecnico("Carlos Pérez", 1002, desarrollo, "Backend");

        desarrollo.agregarEmpleado(gerente1);
        desarrollo.agregarEmpleado(tecnico1);

        Proyecto proyecto1 = new Proyecto("Sistema ERP", "P001");
        Proyecto proyecto2 = new Proyecto("App Móvil", "P002"); // Otro proyecto de ejemplo

        proyecto1.asignarEmpleado(gerente1);
        proyecto1.asignarEmpleado(tecnico1);
        proyecto2.asignarEmpleado(tecnico1); // Técnico asignado a otro proyecto

        gerente1.gestionarProyecto(proyecto1);

        gerente1.contribuir();
        tecnico1.contribuir();

        proyecto1.mostrarEmpleados();
        proyecto2.mostrarEmpleados();

        System.out.print("\nIngrese el ID del empleado para verificar en qué proyectos está asignado: ");
        int idBuscado = scanner.nextInt();

        List<Proyecto> proyectosEmpleado = obtenerProyectosPorEmpleado(idBuscado, List.of(proyecto1, proyecto2));

        if (!proyectosEmpleado.isEmpty()) {
            System.out.println("\nEl empleado con ID " + idBuscado + " está asignado a los siguientes proyectos:");
            for (Proyecto p : proyectosEmpleado) {
                System.out.println("- " + p.getNombre());
            }
        } else {
            System.out.println("\nEl empleado con ID " + idBuscado + " no está asignado a ningún proyecto.");
        }
        scanner.close();
    }
    public static List<Proyecto> obtenerProyectosPorEmpleado(int idEmpleado, List<Proyecto> proyectos) {
        List<Proyecto> proyectosEmpleado = new ArrayList<>();
        for (Proyecto proyecto : proyectos) {
            if (proyecto.estaEmpleadoEnProyecto(idEmpleado)) {
                proyectosEmpleado.add(proyecto);
            }
        }
        return proyectosEmpleado;
    }
}
