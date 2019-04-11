package code;

import java.util.Arrays;

public class Trash {

    public static void main(String[] args) {

        int[] a = new int[]{1,3};
        System.out.println(Arrays.binarySearch(a, 0, 2, 2));
    }
}
