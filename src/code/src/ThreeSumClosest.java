import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] d = new int[]{1, 1, 1, 0};
        System.out.print(solution.threeSumClosest(d, 100));

    }

    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int start;
            int end;
            int closest = Integer.MAX_VALUE;
            int result=0;
            for(int i=0; i<nums.length - 2; i++){
                start = i+1;
                end=nums.length -1 ;
                while (start<end){
                    if(closest>Math.abs(target-(nums[i] + nums[start] + nums[end]))){
                        closest=Math.abs(target-(nums[i] + nums[start] + nums[end]));
                        result=nums[i] + nums[start] + nums[end];

                    }
                    if(nums[i] + nums[start] + nums[end] > target){
                        end-=1;
                    }
                    else if(nums[i] + nums[start] + nums[end] < target){
                        start+=1;
                    }
                    else {
                        return target;
                    }
                }
            }
            return result;
        }
    }
}
