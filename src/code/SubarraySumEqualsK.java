package code;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subarraySum(new int[]{-1, -1, 1}, 0);
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> hMap = new HashMap();

            int sum = 0;
            int finalAns = 0;
            for(int i : nums) {
                sum += i;
                if(sum == k) {
                    finalAns += 1;
                }
                if(hMap.containsKey(sum - k)) {
                    finalAns += hMap.get(sum - k);
                    hMap.put(sum, hMap.getOrDefault(sum, 0) + 1);
                } else {
                    hMap.put(sum, hMap.getOrDefault(sum, 0) + 1);
                }
            }
            return finalAns;
        }
    }
}
