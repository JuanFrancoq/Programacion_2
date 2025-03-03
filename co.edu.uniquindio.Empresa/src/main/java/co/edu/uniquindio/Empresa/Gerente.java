package co.edu.uniquindio.Empresa;

import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Gerente extends Empleado implements  Contribuyente{
    private List<Proyecto> proyectosGestionados = new ArrayList<>();

    public Gerente(String nombre, int idEmpleado, Departamento departamento) {
        super(nombre, idEmpleado, departamento);
        this.proyectosGestionados = proyectosGestionados;
    }

    public void gestionarProyecto(Proyecto proyecto) {
        proyectosGestionados.add(proyecto);
    }

    @Override
    public void contribuir() {
        System.out.println("El gerente " + nombre + " supervisa los proyectos y coordina el equipo.");
    }
}
