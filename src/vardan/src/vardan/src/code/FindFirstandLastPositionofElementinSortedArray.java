package code;

public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        Solution solutions = new Solution();
        System.out.println(solutions.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[] {helperFirst(nums, target, 0, nums.length - 1), helperLast(nums, target, 0, nums.length - 1)};
        }
        public  int helperFirst(int[] nums, int target, int start, int end) {

            if(start > end) {
                return  -1;
            }
            int mid = (start + end) / 2;
            if((mid == 0 && nums[mid] == target ) || (mid > 0 && nums[mid] == target && nums[mid -1] != nums[mid])) {
                return mid;
            } else if(nums[mid] >= target) {
                return helperFirst(nums, target, start, mid - 1);
            } else if(nums[mid] < target) {
                return helperFirst(nums, target, mid + 1, end);
            }
            return -1;
        }

        public int helperLast(int[] nums, int target, int start, int end) {
            if(start > end) {
                return  -1;
            }
            int mid = (start + end) / 2;
            if((mid == nums.length - 1 && nums[mid] == target ) || (mid < nums.length - 1 && nums[mid] == target && nums[mid + 1] != nums[mid])) {
                return mid;
            } else if(nums[mid] > target) {
                return helperLast(nums, target, start, mid - 1);
            } else if(nums[mid] <= target) {
                return helperLast(nums, target, mid + 1, end);
            }
            return -1;
        }
    }


}
