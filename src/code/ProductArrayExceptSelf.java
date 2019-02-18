package code;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 2, 3, 4};
        for (int i : solution.productExceptSelf(nums)) {
            System.out.println(i);
        }
    }


    public static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] answer = new int[nums.length];
            int number = 1;

            answer[answer.length - 1] = 1;

            for (int i = answer.length - 2; i >= 0; i--) {
                answer[i] = number * nums[i + 1];
                number = answer[i];
            }

            number = nums[0];
            nums[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                int k = nums[i];
                nums[i] = number * nums[i - 1];
                number = k;
            }
            nums[0] = 1;

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answer[i] * nums[i];
            }

            return answer;
        }
    }
}
