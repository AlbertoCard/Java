package Busqueda;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numeros = {34, 7, 23, 32, 5, 62, 32, 12};

        System.out.println("Array desordenado:");
        System.out.println(Arrays.toString(numeros));

        mayor(numeros);

        System.out.println("Array ordenado de Mayor a Menor:");
        System.out.println(Arrays.toString(numeros));

        menor(numeros);

        System.out.println("Array ordenado de Menor a Mayor:");
        System.out.println(Arrays.toString(numeros));
    }
    public static void mayor(int[] arr){
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Si no hubo intercambio, el array está ordenado
            if (!swapped) break;
        }
    }
    public static void menor(int[] arr){
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Si no hubo intercambio, el array está ordenado
            if (!swapped) break;
        }
    }
}
