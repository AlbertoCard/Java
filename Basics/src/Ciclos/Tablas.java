package Ciclos;
import java.util.Scanner;

public class Tablas {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
        System.out.println("Proporciona el numero de la tabla que requieres:");
        int num = scn.nextInt();
        Tabla(num);
        } catch (Exception e){
            System.err.println(e);
        }

    }

    public static void Tabla(int n){
        for (int i = 1; i <= 10; i++) {
            System.out.println(n +" x " + i + " = "+(n*i));
        }
    }
}
