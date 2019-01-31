package code;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.subsets(new int[]{1,2,3});
        System.out.println();
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> answer = new ArrayList();
            List<Integer> semi = new ArrayList();
            this.helper(0, 0, answer, semi, nums );
            return answer;
        }


        public void helper(int index, int length, List<List<Integer>> answer, List<Integer> semi, int[] nums) {

            if(length>nums.length || index >= nums.length) {
                return;
            }
            if(semi.size() == length) {
                answer.add(new ArrayList(semi));
                this.helper(index, length + 1, answer, semi, nums);
            }

            else {
                for(int i=index; i<nums.length; i++) {
                    semi.add(nums[i]);
                    this.helper(index + 1, length, answer, semi, nums);
//                    semi.remove(semi.indexOf(nums[i]));

                }
            }

        }

    }


}

