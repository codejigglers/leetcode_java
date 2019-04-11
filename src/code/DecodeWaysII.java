package code;

public class DecodeWaysII {

    public static void main(String[] args) {

    }

    static class Solution {
        public int numDecodings(String s) {
            int lastPossibility = 0;
            int twoLastPossibility = 0;
            if(s.charAt(0) == '*') {
                lastPossibility = 9;
            } else {
                lastPossibility = 1;
            }
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == '*') {

                }
            }
            return 1;
        }
    }
}
