package co.edu.uniquindio.Empresa;

import java.util.List;
import java.util.ArrayList;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Departamento desarrollo = new Departamento("Desarrollo", "D001");

        Gerente gerente1 = new Gerente("Ana López", 1004870686, desarrollo);
        Tecnico tecnico1 = new Tecnico("Carlos Pérez", 1002, desarrollo, "Backend");

        desarrollo.agregarEmpleado(gerente1);
        desarrollo.agregarEmpleado(tecnico1);

        Proyecto proyecto1 = new Proyecto("Sistema ERP", "P001");
        proyecto1.asignarEmpleado(gerente1);
        proyecto1.asignarEmpleado(tecnico1);

        gerente1.gestionarProyecto(proyecto1);

        gerente1.contribuir();
        tecnico1.contribuir();

        proyecto1.mostrarEmpleados();
    }
}