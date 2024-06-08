package Ciclos;
import java.util.Arrays;
import java.util.Scanner;
public class Sumar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] arr = new int[5];
        try{
            System.out.println("introduce 5 numeros y se te devolvera la suma");
            for (int i = 0; i < 5; i++) {
                int num = scn.nextInt();
                arr[i] =+ num;
            }
            System.out.println(Arrays.toString(arr));
            Sumar(arr);
        } catch (Exception e){
            System.out.println(e);
        }

    }
    public static void Sumar(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
