package code;

import java.util.HashMap;

public class ArrayNesting {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }

    private static class Solution {
        public int arrayNesting(int[] nums) {

            int max = 0;

            int point = 0;
            int chain = 0;
            int p = 0;
            while (point < nums.length) {
                int curCount = 0;
                chain = point;
                while (nums[chain] != -1) {
                    curCount +=1;
                    max = Math.max(curCount, max);
                    p = nums[chain];
                    nums[chain] = -1;
                    chain = p;

                }
                point += 1;

            }
            return max;
        }
    }
}
