package co.edu.uniquindio.Empresa.factory;

import co.edu.uniquindio.Empresa.model.*;
import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory instance;
    private List<Departamento> departamentos;
    private List<Proyecto> proyectos;

    private ModelFactory() {
        departamentos = new ArrayList<>();
        proyectos = new ArrayList<>();
        inicializarDatos();
    }
    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
    private void inicializarDatos() {
        Departamento desarrollo = new Departamento("Desarrollo", "D001");
        Departamento calidad = new Departamento("Calidad", "D002");

        Gerente gerente1 = new Gerente("Ana López", 1001, desarrollo);
        Tecnico tecnico1 = new Tecnico("Carlos Pérez", 1002, desarrollo, "Backend");
        Tecnico tecnico2 = new Tecnico("Luis Gómez", 1003, calidad, "Testing");

        desarrollo.agregarEmpleado(gerente1);
        desarrollo.agregarEmpleado(tecnico1);
        calidad.agregarEmpleado(tecnico2);

        departamentos.add(desarrollo);
        departamentos.add(calidad);

        Proyecto proyecto1 = new Proyecto("Sistema ERP", "P001", desarrollo);
        Proyecto proyecto2 = new Proyecto("App Móvil", "P002", calidad);

        proyectos.add(proyecto1);
        proyectos.add(proyecto2);

        proyecto1.asignarEmpleado(gerente1);
        proyecto1.asignarEmpleado(tecnico1);
        proyecto2.asignarEmpleado(tecnico2);

        gerente1.gestionarProyecto(proyecto1);
    }
    public void mostrarListaEmpleados() {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        for (Departamento depto : departamentos) {
            System.out.println("Departamento: " + depto.getNombre());
            for (Empleado emp : depto.getEmpleados()) {
                emp.mostrarInfo();
            }
        }
    }
    public void mostrarListaDepartamentos() {
        System.out.println("\n=== LISTA DE DEPARTAMENTOS ===");
        for (Departamento depto : departamentos) {
            System.out.println("Código: " + depto.getCodigo() + " - Nombre: " + depto.getNombre());
        }
    }
    public void mostrarListaProyectos() {
        System.out.println("\n=== LISTA DE PROYECTOS ===");
        for (Proyecto proyecto : proyectos) {
            System.out.println("Código: " + proyecto.getCodigo() + " - Nombre: " + proyecto.getNombre());
        }
    }
    public void buscarProyectosPorEmpleado(int idEmpleado) {
        System.out.println("\n=== PROYECTOS DEL EMPLEADO ===");
        for (Proyecto proyecto : proyectos) {
            if (proyecto.estaEmpleadoEnProyecto(idEmpleado)) {
                System.out.println("- " + proyecto.getNombre());
            }
        }
    }
    public void buscarDepartamentoPorCodigo(String codigo) {
        System.out.println("\n=== DEPARTAMENTO DEL PROYECTO ===");
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("El proyecto " + codigo + " pertenece al departamento " +
                        proyecto.getDepartamento().getNombre());

                return;
            }
        }
        System.out.println("No se encontró un proyecto con el código ingresado.");
    }
    public void buscarTecnicosPorDepartamento(String codigo) {
        System.out.println("\n=== TÉCNICOS EN EL DEPARTAMENTO ===");
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigo().equalsIgnoreCase(codigo)) {
                for (Empleado empleado : departamento.getEmpleados()) {
                    if (empleado instanceof Tecnico) {
                        empleado.mostrarInfo();
                    }
                }
                return;
            }
        }
        System.out.println("No se encontraron técnicos en el departamento con código " + codigo);
    }
    public void mostrarProyectosGestionadosPorGerente() {
        System.out.println("\n=== PROYECTOS GESTIONADOS POR GERENTES ===");
        for (Departamento depto : departamentos) {
            for (Empleado empleado : depto.getEmpleados()) {
                if (empleado instanceof Gerente) {
                    Gerente gerente = (Gerente) empleado;
                    System.out.println("Gerente: " + gerente.getNombre());
                    for (Proyecto proyecto : proyectos) {
                        if (proyecto.getListaEmpleadosAsignados().contains(gerente)) {
                            System.out.println("- " + proyecto.getNombre());
                        }
                    }
                }
            }
        }
    }
}
