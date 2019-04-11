package code;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,1};
        solution.firstMissingPositive(a);
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            if(nums.length == 0) {
                return 1;
            }
            int flag = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == nums.length) {
                    flag = 1;
                }
                if(nums[i] <= 0) {
                    nums[i] = nums.length + 1;
                }
            }

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= nums.length && nums[i] > 0) {
                    if(nums[nums[i] - 1] > 0)
                    nums[nums[i] - 1] = -1  * nums[nums[i] - 1];
                } else if (nums[i] < 0) {
                    if((-1 * nums[i]) < nums.length && nums[(-1 * nums[i]) - 1] > 0) {
                        nums[(-1 * nums[i]) - 1] = -1  * nums[(-1 * nums[i]) - 1];
                    }
                }
            }

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] >= 0) {
                    return i;
                }
            }

            return nums.length + 1;
        }
    }
}
