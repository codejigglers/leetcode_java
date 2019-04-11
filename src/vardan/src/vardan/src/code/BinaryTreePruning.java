package code;

public class BinaryTreePruning {



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(1);
        treeNode.left.left.left = new TreeNode(0);
        treeNode.right = new TreeNode(0);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(1);

        Solution solution = new Solution();
        solution.pruneTree(treeNode);
        System.out.println("D");
    }

    private static class Solution {
        public TreeNode pruneTree(TreeNode root) {
            helper(root);
            return root;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                if (root.val == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }

            if (root.val == 0) {
                int left = helper(root.left);
                int right = helper(root.right);
                if(left  == 0 ) {
                    root.left = null;
                }
                if(right == 0) {
                    root.right = null;
                }
                return left + right;
            } else {
                int left = helper(root.left);
                int right = helper(root.right);
                if(left  == 0 ) {
                    root.left = null;
                }
                if(right == 0) {
                    root.right = null;
                }
                return left + right;
            }
        }


    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
