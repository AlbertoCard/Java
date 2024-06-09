package Busqueda;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numeros = {34, 7, 23, 32, 5, 62, 32, 12};

        System.out.println("Array desordenado:");
        System.out.println(Arrays.toString(numeros));

        quicksort(numeros, 0, numeros.length - 1);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(numeros));
    }

    public static void quicksort(int A[], int izq, int der){
        int pivote = A[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j){
            while (A[i] <= pivote && i < j)i++;
            while (A[j] > pivote) j--;
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];
        A[j] = pivote;

        if (izq < j-1){
            quicksort(A, izq, j-1);
        }
        if (j+1 < der){
            quicksort(A,j+1, der);
        }
    }
}
