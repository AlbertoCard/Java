package Ciclos;
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduce un palabra:");
        String palabra = scn.next();
        Reversa(palabra);
    }
    public static void Reversa(String palabra){
        String volteada = "";
        palabra = palabra.replaceAll("\\s", "");
        for (int i = palabra.length() - 1; i >= 0; i--) {
            volteada += palabra.charAt(i);
        }
        System.out.println(palabra +" = "+ volteada);
        if(palabra.equals(volteada)){
            System.out.println("Si es palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }
}
