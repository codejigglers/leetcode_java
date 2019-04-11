package code;

public class DistributeCoinsBinaryTree {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(0);
        treeNode.left.right = new TreeNode(3);

        int d = solution.distributeCoins(treeNode);
        System.out.println(d);
    }


    private static class Solution {

        public int distributeCoins(TreeNode root) {




            int[] a = new int[]{0, 0};
            int[] x = this.totalCoinsNodes(root, a);

            int coinPerNode = x[0] / x[1];
            int[] m = new int[]{0};
            int y = helper(root, coinPerNode, 0, m);
            return m[0];

        }

        public int helper(TreeNode root, int coinPerNode, int transact, int[] steps) {

            if (root == null) {
                return 0;
            }

            int a = helper(root.left, coinPerNode, transact, steps);
            int b = helper(root.right, coinPerNode,transact, steps);

            root.val = root.val + a + b;
            int toGive = root.val - coinPerNode;
            steps[0] = steps[0] + Math.abs(toGive);


            return toGive;
        }


        public int[] totalCoinsNodes(TreeNode root, int[] a) {

            if (root != null) {
                a[0] = a[0] + 1;
                a[1] = a[1] + root.val;

                this.totalCoinsNodes(root.left, a);
                this.totalCoinsNodes(root.right, a);

            }

            return a;

        }
    }

}
