package Colas;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> cola = new LinkedList();

        for (int i = 0; i < 10; i++) {
            cola.offer(i);
        }

        System.out.println(cola);
        cola.remove();
        System.out.println(cola);
        System.out.println(cola.peek());
    }
}
