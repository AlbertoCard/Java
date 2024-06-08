package Operaciones;
import java.util.Scanner;


public class Factorial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
            System.out.println("Introduce un numero:");
            int n = scn.nextInt();
            System.out.println(n + "! = " + Factorial(n));
        } catch (Exception e){
            System.err.println(e);
        }
    }
    public static int Factorial(int n){
        if(n < 1){
            throw new ArithmeticException("No se puede sacar factorial de "+n);
        }
        if(n > 16){
            throw new ArithmeticException("Se excedio el limite de int");
        }
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f =+ f * i;
        }
        return f;
    }
}
