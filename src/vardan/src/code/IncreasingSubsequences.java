package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findSubsequences(new int[]{1, 3, 1, 1});
    }

    static class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> finalAns = new ArrayList();
            ArrayList<Integer> midAns = new ArrayList();
            helper(0, nums, finalAns, midAns);

            return finalAns;
        }

        public List<Integer> helper(int start, int[] nums, List<List<Integer>> finalAns, ArrayList<Integer> midAns) {
            if (midAns.size() > 1) {
                ArrayList<Integer> newList = new ArrayList();
                for(Integer i : midAns) {
                    newList.add(i);
                }
                finalAns.add(newList);
            }

            if(start >= nums.length) {
                return null;
            }

            for(int i = start; i < nums.length; i++) {
                if(midAns.size() == 0) {
                    int g = nums[i];
                    boolean flag = false;
                    for(int m = start; m < i; m++) {
                        if(g == nums[m]){
                            flag = flag || true;
                        }
                    }
                    if( start != i && flag) {
                        continue;
                    }
                    midAns.add(nums[i]);
                    helper(i + 1, nums, finalAns, midAns);
                    midAns.remove(midAns.size() - 1);
                } else {
                    if(nums[i] >= midAns.get(midAns.size() - 1)) {
                        int g = nums[i];
                        boolean flag = false;
                        for(int m = start; m < i; m++) {
                            if(g == nums[m]){
                                flag = flag || true;
                            }
                        }
                        if( start != i && flag) {
                            continue;
                        }
                        midAns.add(nums[i]);
                        helper(i + 1, nums, finalAns, midAns);
                        midAns.remove(midAns.size() - 1);
                    }
                }
            }
            return midAns;
        }
    }
}
