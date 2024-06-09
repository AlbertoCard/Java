package Busqueda;

import java.util.Arrays;

public class SelectionSort {
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
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            int max = i;

            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }
            int temp = A[max];
            A[max] = A[i];
            A[i] = temp;
        }
    }
    public static void menor(int[] A){
        int n = A.length;

        for (int i = 0; i < n-1; i++) {
            int min = i;

            for (int j = i+1; j < n; j++) {
                if (A[j] < A[min]){
                    min = j;
                }
                int temp = A[min];
                A[min] = A[i];
                A[i] = temp;
            }
        }
    }

}
