package code;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        Solution solution = new Solution();
        Arrays.sort(a);
        solution.fourSum(a, 0);
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer[]> indexPool = new ArrayList<>();
            List<List<Integer>> answer = new ArrayList<>();

            if(nums.length < 4) {
                return answer;
            }
            for(int i = 0; i < nums.length - 1; i++) {
                if(i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for(int j = i + 1; j < nums.length; j++) {
                    if(j > i + 1 && nums[j] != nums[j-1]) {
                        a.add(nums[i] + nums[j]);
                    }
                }
            }
            Collections.sort(a);
            Collections.sort(indexPool, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    if(nums[o1[0]] + nums[o1[1]] > nums[o2[0]] + nums[o2[1]]){
                        return 1;
                    } else if(nums[o1[0]] + nums[o1[1]] < nums[o2[0]] + nums[o2[1]]){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            int start = 0;
            int end = indexPool.size() - 1;
            HashSet<String> hashSet = new HashSet<>();
            while (start < end) {
                if(a.get(start) + a.get(end) < target) {
                    start += 1;
                } else if(a.get(start) + a.get(end) > target) {
                    end -= 1;
                } else {
                    ArrayList<Integer> dataPoint = new ArrayList<>();
                    dataPoint.add(nums[indexPool.get(start)[0]]);
                    dataPoint.add(nums[indexPool.get(start)[1]]);
                    dataPoint.add(nums[indexPool.get(end)[0]]);
                    dataPoint.add(nums[indexPool.get(end)[1]]);
                    start += 1;
                    Collections.sort(dataPoint);
                    StringBuilder s = new StringBuilder();
                    for(Integer point : dataPoint) {
                        s.append(point);
                        s.append("#");
                    }
                    if(!hashSet.contains(s.toString())) {
                        hashSet.add(s.toString());
                        answer.add(dataPoint);
                    }
                }
            }
            return answer;
        }
    }
}
