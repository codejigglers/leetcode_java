package code;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> answer = solution.subsets(new int[]{1,2,3});
        System.out.println();
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            List<Integer> semi = new ArrayList<>();
            helper(0, 1, answer, semi, nums);
            return answer;
        }


        public void helper(int index, int length, List<List<Integer>> answer, List<Integer> semi, int[] nums) {
            if(index >= nums.length) {
                return;
            }

            for(int i = index; i<nums.length; i++) {
                semi.add(nums[i]);
                if(length == semi.size()) {
                    answer.add(new ArrayList<>(semi));
                }
                helper(index + 1, length + 1, answer, semi, nums);
                semi.remove(semi.size() - 1);

            }
        }

    }


}

