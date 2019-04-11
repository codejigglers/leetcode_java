package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeFlip {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pancakeSort(new int[]{3,2,4,1});
    }

    static class Solution {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> answer = new ArrayList<>();

            for(int i = A.length; i > 0; i--) {
                int index = findIndex(A, i);
                if(index + 1 == i) {
                    continue;
                } else {
                    if(index != 0) {
                        answer.add(index + 1);
                        flip(A, 0, index);
                    }
                    answer.add(i);
                    flip(A, 0, i-1);
                }
            }
            return answer;
        }

        public static int findIndex(int[] A, int a) {
            for(int i = 0; i < A.length; i++) {
                if(A[i] == a) {
                    return i;
                }
            }
            return -1;
        }
        public static void flip(int[] A, int start, int end) {
            while (start < end) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }
}
