package Personas;

public class Estudiante extends Persona{

    private int numControl;
    private int semestre;
    private double promedio;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, String apellido, int edad, int numControl, int semestre, double promedio) {
        super(id, nombre, apellido, edad);
        this.numControl = numControl;
        this.semestre = semestre;
        this.promedio = promedio;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
