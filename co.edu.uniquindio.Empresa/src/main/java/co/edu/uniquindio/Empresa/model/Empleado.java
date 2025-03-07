package co.edu.uniquindio.Empresa.model;

public class Empleado {
    public String nombre;
    public int idEmpleado;
    public Departamento departamento;

    public Empleado(String nombre, int idEmpleado, Departamento departamento) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", Departamento: " + (departamento != null ? departamento.getNombre() : "Sin departamento");
    }

    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre + ", ID: " + idEmpleado + ", Departamento: " + departamento.getNombre());
    }
}