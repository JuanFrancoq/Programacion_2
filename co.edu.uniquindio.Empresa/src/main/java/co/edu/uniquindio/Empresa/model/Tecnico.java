package co.edu.uniquindio.Empresa.model;

import co.edu.uniquindio.Empresa.model.Contribuyente;

public class Tecnico extends Empleado implements Contribuyente {
    private String especialidad;

    public Tecnico(String nombre, int idEmpleado, Departamento departamento, String especialidad) {
        super(nombre, idEmpleado, departamento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "especialidad='" + especialidad + '\'' +
                '}';
    }

    @Override
    public void contribuir() {
        System.out.println("El técnico " + nombre + " realiza tareas técnicas especializadas en " + especialidad + ".");
    }
}
