package Personas;

public class Empleado extends Persona{

    private int numEmp;
    private String puesto;
    private int sueldo;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, int edad, int numEmp, String puesto, int sueldo) {
        super(id, nombre, apellido, edad);
        this.numEmp = numEmp;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
