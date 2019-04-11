public class MajorityElement {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

        static class Solution {
            public int majorityElement(int[] nums) {
                int count = 1;
                int current = nums[0];

                for(int i = 1; i < nums.length; i++) {
                    if(nums[i] == current) {
                        count += 1;
                    } else {
                        count -= 1;
                        if(count == 0) {
                            current = nums[i];
                        }
                    }
                }

                return current;
            }
        }
}
