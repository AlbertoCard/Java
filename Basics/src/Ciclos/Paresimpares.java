package Ciclos;
import java.util.Scanner;

public class Paresimpares {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("introduce un numero y se imprimiran");
        System.out.println("los numeros pares e impares.");
        int num = scn.nextInt();
        Pares(num);
        Impares(num);

    }

    public static void Pares(int n){
        String pares = "";
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0) {
                pares = pares.concat(i+", ");
            }
        }
        System.out.println(pares);
    }
    public static void Impares(int n){
        String impares = "";
        for (int i = 1; i <= n; i++) {
            if(i % 2 != 0) {
                impares = impares.concat(i+", ");
            }
        }
        System.out.println(impares);
    }
}
