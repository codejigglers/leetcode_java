package code;

public class MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[] = {0,0,1,0,0,0,0,0};
        solution.moveZeroes(a);

        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length < 2) {
                return;
            }

            int i = 0;
            int j = 1;
            while (j < nums.length) {
                if(nums[i] == 0 && nums[j] == 0) {
                    j+=1;
                }
                else if(nums[i]!=0 && nums[j]==0) {
                    i+=1;
                    j+=1;
                }
                else if(nums[i]==0 && nums[j]!=0) {
                    int y = nums[i];
                    nums[i] = nums[j];
                    nums[j] = y;
                    i+=1;
                    j+=1;
                }
                else if(nums[i] ==0 && nums[j]==0){
                    j+=1;
                }
                else {
                    i+=1;
                    j+=1;
                }
            }
        }
    }
}
