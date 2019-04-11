package code;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[]{7, 5, 8, 1, 8});
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }
    }
}
