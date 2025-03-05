package co.edu.uniquindio.Empresa;

import co.edu.uniquindio.Empresa.factory.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ModelFactory modelFactory = ModelFactory.getInstance();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Mostrar lista de empleados");
            System.out.println("2. Mostrar lista de departamentos");
            System.out.println("3. Mostrar lista de proyectos");
            System.out.println("4. Buscar proyectos por empleado");
            System.out.println("5. Buscar departamento por código de proyecto");
            System.out.println("6. Buscar técnicos por código de departamento");
            System.out.println("7. Mostrar proyectos gestionados por gerente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    modelFactory.mostrarListaEmpleados();
                    break;
                case 2:
                    modelFactory.mostrarListaDepartamentos();
                    break;
                case 3:
                    modelFactory.mostrarListaProyectos();
                    break;
                case 4:
                    System.out.print("\nIngrese el ID del empleado: ");
                    int idEmpleado = scanner.nextInt();
                    modelFactory.buscarProyectosPorEmpleado(idEmpleado);
                    break;
                case 5:
                    System.out.print("\nIngrese el código del proyecto: ");
                    String codigoProyecto = scanner.next();
                    modelFactory.buscarDepartamentoPorCodigo(codigoProyecto);
                    break;
                case 6:
                    System.out.print("\nIngrese el código del departamento: ");
                    String codigoDepto = scanner.next();
                    modelFactory.buscarTecnicosPorDepartamento(codigoDepto);
                    break;
                case 7:
                    modelFactory.mostrarProyectosGestionadosPorGerente(); // Opción agregada
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
