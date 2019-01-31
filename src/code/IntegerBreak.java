package code;

public class IntegerBreak {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(9));
    }

    public static class Solution {
        public int integerBreak(int n) {
            if(n==0){
                return 0;
            }
            return helper(1, n);
        }

        public int helper(int ans, int n) {
            if(n<=4) {
                return ans*n;
            }
            else {
                return helper(ans*3, n-3);
            }
        }
    }
}
