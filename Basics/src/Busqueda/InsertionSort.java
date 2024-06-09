package Busqueda;

import java.util.Arrays;

public class InsertionSort {
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

    public static void mayor(int[] A){
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] < key) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }

    }
    public static void menor(int[] A){
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
    }
}
