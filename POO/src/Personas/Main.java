package Personas;

public class Main {

    public static void main(String[] args) {

        Persona[] personas = new Persona[5];

        personas[0] = new Empleado(1, "Alberto", "Cardenas", 21, 90319027, "Programader", 10000);
        personas[1] = new Estudiante(2, "Ramses", "Aldama", 21, 20170837, 8, 92);
        personas[2] = new Persona(3, "Samuel", "Moreno", 21);
        personas[3] = new Persona(4, "Alan", "Meza", 21);
        personas[4] = new Persona(5, "Luis", "Lie", 21);

        for (Persona p : personas){
            p.presentarse();
        }

    }

}
