package code;

import java.util.Stack;

public class ScoreofParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.scoreOfParentheses("()"));
    }

    private static class Solution {
        public int scoreOfParentheses(String S) {
            Stack<String> stack = new Stack<>();

            for(int i=0; i<S.length(); i++){
                Character c = S.charAt(i);
                if(c.toString().equals(")")){
                    String first = stack.pop();
                    if(first.equals("(")){
                        stack.add("1");
                        continue;
                    }
                    else {
                        if(stack.peek().equals("(")){
                            stack.pop();
                            int ans = Integer.parseInt(first)*2;
                            stack.add(String.valueOf(ans));
                            continue;
                        }
                        else {
                            int ans = Integer.parseInt(first);
                            while (!stack.peek().equals("(")){
                                ans+=Integer.valueOf(stack.pop());
                            }
                            stack.pop();
                            stack.add(String.valueOf(ans*2));
                            continue;
                        }
                    }
                }
                else {
                    Character d = S.charAt(i);
                    stack.add(d.toString());
                }
            }

            int toReturn=0;
            while (!stack.isEmpty()){
                toReturn+=Integer.parseInt(stack.pop());
            }

            return toReturn;
        }
    }
}
