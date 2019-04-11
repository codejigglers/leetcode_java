package code;

public class RangeSumQueryImmutable {


    public static void main(String[] args) {

    }

    static class NumArray {

        int[] dp;
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
            dp = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++) {
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(i == j) {
                return nums[i];
            } else {
                return dp[j + 1] - dp[i];
            }
        }
    }
}
