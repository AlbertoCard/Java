package Colas;

import java.util.LinkedList;
import java.util.Queue;

public class ColaAlumnos {
    public static void main(String[] args) {
            // Crear una cola de tipo Alumno
            Queue<Alumno> cola = new LinkedList();

            // Agregar objetos Alumno a la cola
            cola.offer(new Alumno("Juan", 20));
            cola.offer(new Alumno("María", 22));
            cola.offer(new Alumno("Pedro", 21));
            cola.offer(new Alumno("Ana", 23));
            cola.offer(new Alumno("Luis", 24));
            cola.offer(new Alumno("Elena", 22));
            cola.offer(new Alumno("Carlos", 25));
            cola.offer(new Alumno("Sofía", 21));
            cola.offer(new Alumno("Miguel", 20));
            cola.offer(new Alumno("Laura", 23));

            System.out.println();

            cola.remove();

            System.out.println(cola.peek().getNombre());
            System.out.println(cola.peek().getEdad());

            System.out.println(cola.peek());

    }
}
