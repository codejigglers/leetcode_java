package code;

public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            return helperFunction(root, 0);
        }

        public int helperFunction(TreeNode root, int n) {
            if(root==null) {
                return n;
            }

            else {
                return Math.max(helperFunction(root.left, n+1), helperFunction(root.right, n+1));
            }
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
