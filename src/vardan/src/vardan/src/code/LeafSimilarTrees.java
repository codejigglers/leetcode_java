package code;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> data1 = new ArrayList<>();
            List<Integer> data2 = new ArrayList<>();

            this.findLeaf(root1, data1);
            this.findLeaf(root2, data2);

            if(data1.size() != data2.size()) {
                return false;
            }

            for(int i=0; i<data1.size(); i++) {
                if(data1.get(i) != data2.get(i)) {
                    return false;
                }
            }

            return true;

        }

        public void findLeaf(TreeNode root, List<Integer> data) {

            if(root==null) {
                return ;
            }

            if(root.left != null) {
                this.findLeaf(root.left, data );
            }

            if(root.left == null && root.right==null) {
                data.add(root.val);
            }

            if(root.right != null) {
                this.findLeaf(root.right, data);
            }

        }
    }
}
