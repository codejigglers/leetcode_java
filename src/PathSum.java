public class PathSum {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.left.left = new TreeNode(-1);


        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(treeNode, -1));

    }

    private static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {

            if (root == null) {
                return false;
            }
            if (sum - root.val == 0) {
                if (root.left == null && root.right == null) {
                    return true;
                } else {
                    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
                }
            } else {
                return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
            }

        }
    }
}


