package Operaciones;
import java.util.Scanner;
import static java.lang.Math.pow;

public class MulDiv {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Este programa realiza las siguientes operaciones:");
        System.out.println("Multiplica, Divide, Modula y Exponencia,");
        System.out.println("el primer número por el segundo.");

        try {
            System.out.println("Introduce el primer valor:");
            double a = scn.nextDouble();
            System.out.println("Introduce el segundo valor:");
            double b = scn.nextDouble();

            System.out.println("Resultados:");
            System.out.println(a + " x " + b + " : " + Multiplica(a,b));
            System.out.println(a + " / " + b + " : " + Divide(a,b));
            System.out.println(a + " % " + b + " : " + Modulo(a,b));
            System.out.println(a + " ^ " + b + " : " + Exponente(a,b));

        } catch (Exception e){
            System.out.println(e);
            System.err.println("Sonso");
        }

    }

    public static Double Multiplica(double a, double b){
        return a*b;
    }

    public static Double Divide(double a, double b){
        if(b == 0){
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a/b;
    }

    public static Double Modulo(double a, double b){
        if(b == 0){
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a%b;
    }

    public static Double Exponente(double a, double b){
        double ex = pow(a,b);
        return ex;
    }
}
