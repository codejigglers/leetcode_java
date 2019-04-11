import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});

        for(int i=0; i<result.length; i++)
        {
            System.out.print(result[i]);
        }
    }

    private static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {


            Stack<Integer> stack = new Stack<>();
            int[] ans = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if (temperatures[stack.peek()] < temperatures[i]) {
                        while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                            ans[stack.peek()]=i-stack.pop();
                        }
                        stack.push(i);
                    }
                    else {
                        stack.push(i);
                    }
                }
            }

            return ans;
        }
    }
}
