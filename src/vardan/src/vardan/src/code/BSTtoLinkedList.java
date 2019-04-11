package vardan.src.code;

public class BSTtoLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 4;
        node1.left = new Node();
        node1.left.val = 2;
        node1.right = new Node();
        node1.right.val = 5;
        node1.left.right = new Node();
        node1.left.right.val = 3;
        node1.left.left = new Node();
        node1.left.left.val = 1;

//        Node node1 = new Node();
//        node1.val = 4;
//        node1.left = new Node();
//        node1.left.val = 1;
//        node1.left.right = new Node();
//        node1.left.right.val = 3;
//        node1.left.right.left = new Node();
//        node1.left.right.left.val = 2;


        Solution solution = new Solution();
        solution.treeToDoublyList(node1);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    static class Solution {

        Node pointer;
        Node tail;

        public Node treeToDoublyList(Node root) {

            if (root == null) {
                return null;
            }
            helperMethod(root);
            tail.right = pointer;
            pointer.left = tail;

            return pointer;


        }

        public Node[] helperMethod(Node root) {
            Node left = null;
            Node right = null;
            int max;
            int min;
            if (root.left == null && pointer == null) {
                pointer = root;
            }
            if (root.left != null) {
                Node[] a = helperMethod(root.left);
                left = a[1];
                left.right = root;
                root.left = left;
                left = a[0];

            }
            if (root.right != null) {
                Node[] a = helperMethod(root.right);
                right = a[0];
                right.left = root;
                root.right = right;
                right = a[1];
            }

            if ((root.left == null && root.right == null) || root.right == null) {
                tail = root;
            }

            Node[] answer = new Node[2];
            answer[0] = root;
            answer[1] = root;
            if (left != null && left.val < root.val) {
                answer[0] = left;
            }
            if (right != null && right.val > root.val) {
                answer[1] = right;
            }
            return answer;
        }

    }
}
