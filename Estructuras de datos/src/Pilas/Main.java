package Pilas;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Alumno alum1 = new Alumno();
        Alumno alum2 = new Alumno("Alberto", 21);
        Alumno alum3 = new Alumno("Ramses", 21);

        Stack<Alumno> pila = new Stack<Alumno>();

        pila.push(alum1);
        pila.push(alum2);
        pila.push(alum3);

        System.out.println(pila.peek().getNombre());
        System.out.println(pila.peek().getEdad());
    }
}
