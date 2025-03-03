package co.edu.uniquindio.Empresa;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de departamentos
        Departamento desarrollo = new Departamento("Desarrollo", "D001");
        Departamento calidad = new Departamento("Calidad", "D002");

        // Creación de empleados
        Gerente gerente1 = new Gerente("Ana López", 1001, desarrollo);
        Tecnico tecnico1 = new Tecnico("Carlos Pérez", 1002, desarrollo, "Backend");
        Tecnico tecnico2 = new Tecnico("Luis Gómez", 1003, calidad, "Testing");

        // Asignación de empleados a los departamentos
        desarrollo.agregarEmpleado(gerente1);
        desarrollo.agregarEmpleado(tecnico1);
        calidad.agregarEmpleado(tecnico2);

        // Lista de departamentos
        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(desarrollo);
        departamentos.add(calidad);

        // Lista de proyectos
        List<Proyecto> proyectos = new ArrayList<>();

        // Creación de proyectos
        Proyecto proyecto1 = new Proyecto("Sistema ERP", "P001", desarrollo);
        Proyecto proyecto2 = new Proyecto("App Móvil", "P002", calidad);

        // Agregar proyectos a la lista
        proyectos.add(proyecto1);
        proyectos.add(proyecto2);

        // Asignación de empleados a los proyectos
        proyecto1.asignarEmpleado(gerente1);
        proyecto1.asignarEmpleado(tecnico1);
        proyecto2.asignarEmpleado(tecnico2);

        // Gerente gestiona un proyecto
        gerente1.gestionarProyecto(proyecto1);

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Mostrar lista de empleados");
            System.out.println("2. Mostrar lista de departamentos");
            System.out.println("3. Mostrar lista de proyectos");
            System.out.println("4. Buscar proyectos por empleado");
            System.out.println("5. Buscar departamento por código de proyecto");
            System.out.println("6. Buscar técnicos por código de departamento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarListaEmpleados(departamentos);
                    break;
                case 2:
                    mostrarListaDepartamentos(departamentos);
                    break;
                case 3:
                    mostrarListaProyectos(proyectos);
                    break;
                case 4:
                    buscarProyectosPorEmpleado(scanner, proyectos);
                    break;
                case 5:
                    buscarDepartamentoPorCodigo(scanner, proyectos);
                    break;
                case 6:
                    buscarTecnicosPorDepartamento(scanner, departamentos);
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

    // Métodos del menú
    public static void mostrarListaEmpleados(List<Departamento> departamentos) {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        for (Departamento depto : departamentos) {
            System.out.println("Departamento: " + depto.getNombre());
            for (Empleado emp : depto.getEmpleados()) {
                emp.mostrarInfo(); // Método en la clase Empleado para mostrar la información
            }
        }
    }

    public static void mostrarListaDepartamentos(List<Departamento> departamentos) {
        System.out.println("\n=== LISTA DE DEPARTAMENTOS ===");
        for (Departamento depto : departamentos) {
            System.out.println("Código: " + depto.getCodigo() + " - Nombre: " + depto.getNombre());
        }
    }

    public static void mostrarListaProyectos(List<Proyecto> proyectos) {
        System.out.println("\n=== LISTA DE PROYECTOS ===");
        for (Proyecto proyecto : proyectos) {
            System.out.println("Código: " + proyecto.getCodigo() + " - Nombre: " + proyecto.getNombre());
        }
    }

    public static void buscarProyectosPorEmpleado(Scanner scanner, List<Proyecto> proyectos) {
        System.out.print("\nIngrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        List<Proyecto> proyectosEmpleado = obtenerProyectosPorEmpleado(idEmpleado, proyectos);

        if (!proyectosEmpleado.isEmpty()) {
            System.out.println("\nEl empleado con ID " + idEmpleado + " está en los siguientes proyectos:");
            for (Proyecto p : proyectosEmpleado) {
                System.out.println("- " + p.getNombre());
            }
        } else {
            System.out.println("\nNo se encontraron proyectos para el empleado con ID " + idEmpleado);
        }
    }

    public static void buscarDepartamentoPorCodigo(Scanner scanner, List<Proyecto> proyectos) {
        System.out.print("\nIngrese el código del proyecto: ");
        String codigoProyecto = scanner.next();
        Departamento departamento = obtenerDepartamentoPorCodigo(codigoProyecto, proyectos);

        if (departamento != null) {
            System.out.println("\nEl proyecto " + codigoProyecto + " está en el departamento: " + departamento.getNombre());
        } else {
            System.out.println("\nNo se encontró un proyecto con el código ingresado.");
        }
    }

    public static void buscarTecnicosPorDepartamento(Scanner scanner, List<Departamento> departamentos) {
        System.out.print("\nIngrese el código del departamento: ");
        String codigoDepto = scanner.next();
        List<Tecnico> tecnicosEncontrados = obtenerTecnicosPorDepartamento(codigoDepto, departamentos);

        if (!tecnicosEncontrados.isEmpty()) {
            System.out.println("\nTécnicos en el departamento " + codigoDepto + ":");
            for (Tecnico tecnico : tecnicosEncontrados) {
                tecnico.mostrarInfo();
            }
        } else {
            System.out.println("\nNo se encontraron técnicos en el departamento con código " + codigoDepto);
        }
    }

    // Métodos auxiliares
    public static List<Proyecto> obtenerProyectosPorEmpleado(int idEmpleado, List<Proyecto> proyectos) {
        List<Proyecto> proyectosEmpleado = new ArrayList<>();
        for (Proyecto proyecto : proyectos) {
            if (proyecto.estaEmpleadoEnProyecto(idEmpleado)) {
                proyectosEmpleado.add(proyecto);
            }
        }
        return proyectosEmpleado;
    }

    public static Departamento obtenerDepartamentoPorCodigo(String codigo, List<Proyecto> proyectos) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return proyecto.getDepartamento();
            }
        }
        return null;
    }

    public static List<Tecnico> obtenerTecnicosPorDepartamento(String codigo, List<Departamento> departamentos) {
        List<Tecnico> tecnicos = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equalsIgnoreCase(codigo.trim())) {
                for (Empleado empleado : departamento.getEmpleados()) {
                    if (empleado instanceof Tecnico) {
                        tecnicos.add((Tecnico) empleado);
                    }
                }
                break;
            }
        }
        return tecnicos;
    }
}
