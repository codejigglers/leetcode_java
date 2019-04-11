package code;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static void main(String[] args) {
        Node a5 = new Node(5, new ArrayList<>());
        Node a6 = new Node(6, new ArrayList<>());
        Node a3 = new Node(3, new ArrayList<>());
        a3.children.add(a5);
        a3.children.add(a6);
        Node a2 = new Node(2, new ArrayList<>());
        Node a4 = new Node(4, new ArrayList<>());
        Node a1 = new Node(1, new ArrayList<>());
        a1.children.add(a3);
        a1.children.add(a2);
        a1.children.add(a4);


        Solution solution = new Solution();
        solution.levelOrder(a1);
    }

    static class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> answer = new ArrayList<>();
            List<Node> stack = new ArrayList<>();
            List<Node> stack2= new ArrayList<>();

            if(root == null) {
                return answer;
            }

            stack.add(root);
            while (stack.size() > 0 || stack2.size()>0) {
                if(stack.size() > 0) {
                    List<Integer> ans = new ArrayList<>();
                    for(Node n : stack) {
                        ans.add(n.val);
                        for (Node m : n.children) {
                            stack2.add(m);
                        }
                    }
                    answer.add(ans);
                    stack.clear();
                }

                else if(stack2.size() > 0) {
                    List<Integer> ans = new ArrayList<>();
                    for(Node n : stack2) {
                        ans.add(n.val);
                        for (Node m : n.children) {
                            stack.add(m);
                        }
                    }
                    answer.add(ans);
                    stack2.clear();
                }
            }

            return answer;


        }
    }
}

