package code;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.braces("(a+(a+b))"));
    }

    static public class Solution {
        public int braces(String A) {

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < A.length(); i++) {
                if(A.charAt(i) == ')') {
                    if(stack.peek() == '(') {
                        return 1;
                    }
                    int count = 0;
                    while (stack.peek() != '(') {
                        stack.pop();
                        count++;
                    }
                    if(count < 2) {
                        return 1;
                    }
                    stack.pop();
                } else {
                    stack.push(A.charAt(i));
                }
            }
            return 0;
        }
    }

}
