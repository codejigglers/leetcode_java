package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDiff {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        int[] a = new int[]{1,2,3,4};

        for (int i : a) {
            list.add(i);
        }
        System.out.println(maxDifferenceOddEven(list));
    }

    static int maxDifferenceOddEven(List<Integer> a) {
        int small = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        int maxDiff = -Integer.MAX_VALUE;

        for (int i : a) {
            if (i % 2 == 0) {
                if (i >= max) {
                    max = i;
                }
                if (small < Math.max(max, i)) {
                    maxDiff = Math.max(maxDiff, Math.max(max, i) - small);
                }
            }
            if (i < small && i % 2 != 0) {
                small = i;
            }

        }
        if (maxDiff > 0) {
            return maxDiff;
        } else {
            return -1;
        }
    }
}
