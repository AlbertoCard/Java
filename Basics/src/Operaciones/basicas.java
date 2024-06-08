package Operaciones;
import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;


public class basicas {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = 0, b = 0;
        try{
            System.out.println("Introduce un numero entero:");
            a = scn.nextInt();
            System.out.println("Introduce otro numero: \n(Si quieres restar introduce un valor negativo)");
            b = scn.nextInt();

            System.out.println("Sumas en variables:");
            System.out.println("Enteros:");
            System.out.println(SumaInt(a,b));
            System.out.println("Short:");
            System.out.println(SumaShort(a,b));
            System.out.println("Byte:");
            System.out.println(SumaByte(a,b));


        } catch (Exception e){
            System.err.println(e);
            System.out.println("Sonso");
        }
    }

    public static byte SumaByte(int a, int b){
        if( (a+b) > 127 || (a+b) < -127 ){
            throw new ArithmeticException("Se excede el limite de byte");
        }
        byte suma = (byte)(a + b);
        return suma;
    }

    public static short SumaShort(int a, int b){
        if( (a+b) > 32767 || (a+b) < -32767 ){
            throw new ArithmeticException("La suma excede el limite de short");
        }
        short suma = (short)(a+b);
        return suma;
    }

    public static int SumaInt(int a, int b){
        if( (a+b) > 2147483647 || (a+b) < -2147483647){
            throw new ArithmeticException("La suma excede el limite de int");
        }
        return a+b;
    }
}
