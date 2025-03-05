package co.edu.uniquindio.Empresa.model;

import java.util.List;
import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private String codigo;
    private List<Empleado> listaEmpleadosAsignados = new ArrayList<>();
    private Departamento departamento;

    public Proyecto() {

    }
    public Proyecto(String nombre, String codigo, Departamento departamento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEmpleadosAsignados = listaEmpleadosAsignados;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Empleado> getListaEmpleadosAsignados() {
        return listaEmpleadosAsignados;
    }

    public void setListaEmpleadosAsignados(List<Empleado> listaEmpleadosAsignados) {
        this.listaEmpleadosAsignados = listaEmpleadosAsignados;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEmpleadosAsignados=" + listaEmpleadosAsignados +
                '}';
    }

    public void asignarEmpleado(Empleado empleado) {
        listaEmpleadosAsignados.add(empleado);
    }

    public void mostrarEmpleados(){
        System.out.println("Lista de empleados: " + listaEmpleadosAsignados);
        for (Empleado empleado : listaEmpleadosAsignados){
            empleado.mostrarInfo();
        }
    }
    public boolean estaEmpleadoEnProyecto(int idEmpleado) {
        for (Empleado empleado : listaEmpleadosAsignados) {
            if(empleado.idEmpleado == idEmpleado){
                return true;
            }
        }
        return false;
    }
}
