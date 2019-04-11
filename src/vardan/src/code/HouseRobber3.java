package code;

public class HouseRobber3 {


    public static void main(String[] args) {

    }

    static class Solution {
        public int rob(TreeNode root) {
            int[] a = helperMethod(root);
            return Math.max(a[0], a[1]);
        }

        public int[] helperMethod(TreeNode root) {
            if(root == null) {
                return new int[]{0,0};
            } else {
                int[] left = helperMethod(root.left);
                int[] right = helperMethod(root.right);

                int[] toReturn = new int[2];
                toReturn[0] = root.val + left[1] + right[1];
                toReturn[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
                return toReturn;
            }
        }
    }
}
