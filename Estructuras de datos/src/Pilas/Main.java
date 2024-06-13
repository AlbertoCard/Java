package Pilas;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] temp = new int[3];
        int[] temp2 = new int[2];
        temp[0] = 1;
        temp[1] = 1;
        //temp[2] = 1;

        temp2[0] = 2;
        temp2[1] = 2;
        System.out.println(temp.length);

        temp = temp2;

        System.out.println(Arrays.toString(temp));
        System.out.println(temp.length);
    }
}
