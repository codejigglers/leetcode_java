package code;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] m = new String[]{"aa", "a"};
        solution.longestCommonPrefix(m);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int start = 0;
            int end = strs[0].length() - 1;
            String main = strs[0];
            for(int i = 1;  i < strs.length; i++) {
                String toCompare = strs[i];
                end = Math.min(end, Math.min(main.length() - 1, toCompare.length() - 1));

                for(int j = 0; j <= end && j < toCompare.length(); j++) {
                    if(main.charAt(j) != toCompare.charAt(j)) {
                        end = j - 1;
                        break;
                    }
                }
            }

            return main.substring(0, end + 1);
        }
    }


}
