package code;

import java.util.Arrays;

public class SquareSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortedSquares(new int[]{-4,0});
    }

    private static class Solution {
        public int[] sortedSquares(int[] A) {

            int pointer1 = -1;
            for(int i=0; i<A.length; i++) {
                if(A[i] > -1){
                    pointer1 = i;
                    break;
                }
            }
            int[] b = A.clone();
            if(pointer1 == -1) {

                for(int i=A.length-1; i>=0; i--) {
                    b[A.length - 1 - i] = A[i]*A[i];
                }
            }
            else {
                if(pointer1 == 0) {
                    for(int i=A.length-1; i>=0; i--) {
                        b[i] = A[i]*A[i];
                    }
                }
                else {
                    int pointer2 = pointer1 - 1;
                    for(int i = 0; i<A.length; i++) {

                        if(pointer2<0  || !(pointer1==A.length) && Math.abs(A[pointer1]) < Math.abs(A[pointer2]) ) {
                            b[i] = A[pointer1] * A[pointer1];
                            pointer1 +=1;
                        }

                        else if(pointer1==A.length  ||  !(pointer2<0) && Math.abs(A[pointer1]) >= Math.abs(A[pointer2])) {
                            b[i] = A[pointer2] * A[pointer2];
                            pointer2 -=1;
                        }
                    }

                }

            }

            return b;
        }
    }
}
