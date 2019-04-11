package code;

import java.util.Collections;

public class SquaresofaSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortedSquares(new int[]{-1, 2, 2});
    }

    static class Solution {
        public int[] sortedSquares(int[] A) {

            int[] ans = new int[A.length];
            if (A.length == 0) {
                return A;
            } else if (A[0] >= 0) {
                for (int i = 0; i < A.length; i++) {
                    A[i] = A[i] * A[i];
                }
                return A;
            } else if (A[A.length - 1] < 0) {
                for (int i = 0; i < A.length; i++) {
                    A[i] = A[i] * A[i];
                }
                for (int i = 0; i < A.length; i++) {
                    int temp = A[i];
                    A[i] = A[A.length - 1 - i];
                    A[A.length - 1 - i] = temp;
                }
                return A;
            } else {
                int breaking = lastNegative(A);
                int startN = breaking;
                int startP = breaking + 1;
                int pointer = 0;
                while (startN >= 0 && startP < A.length) {
                    if (Math.abs(A[startN]) < A[startP]) {
                        ans[pointer] = A[startN] * A[startN];
                        pointer += 1;
                        startN -= 1;
                    } else {
                        ans[pointer] = A[startP] * A[startP];
                        startP += 1;
                        pointer += 1;
                    }
                }

                if (startN >= 0) {
                    while (startN >= 0) {
                        ans[pointer] = A[startN] * A[startN];
                        pointer += 1;
                        startN -= 1;
                    }
                } else if (startP < A.length) {
                    while (startP < A.length) {
                        ans[pointer] = A[startP] * A[startP];
                        pointer += 1;
                        startP += 1;
                    }
                }
            }
            return ans;
        }

        public static int lastNegative(int[] A) {
            for (int i = 1; i < A.length; i++) {
                if (A[i] >= 0 && A[i - 1] < 0) {
                    return i - 1;
                }
            }
            return 0;
        }
    }


}
