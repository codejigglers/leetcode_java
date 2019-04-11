package code;

public class HouseRobber2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.rob(new int[]{1, 2, 1, 1});
        System.out.println(a);
    }

    static class Solution {
        public int rob(int[] nums) {
            if(nums.length == 0) {
                return 0;
            } else if(nums.length == 1) {
                return nums[0];
            } else if(nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dp = new int[nums.length + 1];
            dp[1] = nums[0];
            int a = 0;
            int b = 0;
            for(int i = 2; i < dp.length - 1; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
            }
            a = dp[dp.length - 2];

            dp = new int[nums.length + 1];
            dp[2] = nums[1];
            for(int i = 3; i < dp.length; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
            }
            b = dp[dp.length - 1];
            return Math.max(a, b);
        }
    }
}
