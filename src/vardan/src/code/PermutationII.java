package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permuteUnique(new int[]{-1,2,0,-1,1,0,1});
    }

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> a = new ArrayList<>();
            Arrays.sort(nums);
            helperMethod(nums, 0, a);
            return a;
        }

        public void helperMethod(int[] nums, int startPosition, List<List<Integer>> answer) {

            for(int i= startPosition ; i < nums.length ; i++) {
                if(startPosition == nums.length - 1) {
                    List al = new ArrayList();
                    for(int k : nums) {
                        al.add(k);
                    }
                    answer.add(al);
                }
                if((nums[startPosition] == nums[i] && i != startPosition) || (nums[startPosition] != nums[i] && i >= 1 && nums[i] == nums[i - 1])) {
                    continue;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[startPosition];
                    nums[startPosition] = temp;

                    helperMethod(nums, startPosition + 1, answer);

                    temp = nums[i];
                    nums[i] = nums[startPosition];
                    nums[startPosition] = temp;

                }
            }
        }
    }
}
