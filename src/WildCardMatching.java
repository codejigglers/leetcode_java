public class WildCardMatching {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("aa", "*");
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;

            for (int i = 1; i <= p.length(); i++) {
                dp[0][i] = p.charAt(i - 1) == '*' ? dp[0][i - 1] : false;
            }

            for(int i = 1; i<dp.length; i++) {
                for(int j = 1; j<dp[0].length; j++) {
                    if(s.charAt(i-1) == p.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else if(p.charAt(j-1) == '?') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if(p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}
