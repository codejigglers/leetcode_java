package code;

public class RegularExpression {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("aaa", "ab*a*c*a");
    }


    static class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;

            if(p.equals("")) {
                return false;
            }
            if(p.equals(".*")) {
                return true;
            }
            if(p.charAt(0) == '*') {
                return false;
            }

            for (int i = 1; i <= p.length(); i++) {
                dp[0][i] = p.charAt(i - 1) == '*' ? dp[0][i - 2] : false;
            }

            for(int i = 1; i<dp.length; i++) {
                for(int j = 1; j<dp[0].length; j++) {
                    if(s.charAt(i-1) == p.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else if(p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if(p.charAt(j-1) == '*') {
                        if(s.charAt(i-1) == p.charAt(j-2)) {
                            dp[i][j] = dp[i-1][j] || dp[i][j-2];
                        } else if(s.charAt(i-1) != p.charAt(j-2)) {
                            if(p.charAt(j-2) == '.') {
                                dp[i][j] = dp[i-1][j] || dp[i][j-2];
                            } else {
                                dp[i][j] = dp[i][j-2];
                            }

                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}
