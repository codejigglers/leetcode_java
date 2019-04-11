package code;

public class OneEditDistance {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isOneEditDistance("ab", "ba");
    }

    static class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if(s.equals(t)) {
                return false;
            } else if(Math.max(s.length(), t.length()) - Math.min(s.length(), t.length()) > 1) {
                return false;
            }
            if(s.length() == t.length()) {
                int count = 0;
                for(int i = 0; i<t.length(); i++) {
                    if(s.charAt(i) != t.charAt(i)) {
                        count += 1;
                        if(count > 1) {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                if(s.length() > t.length()) {
                    int sPointer = 0;
                    int tPointer = 0;
                    boolean unequal = false;
                    while (tPointer < t.length()) {
                        if(t.charAt(tPointer) != s.charAt(sPointer)) {
                            sPointer += 1;
                            if(unequal) {
                                return false;
                            } unequal = true;
                        } else {
                            sPointer += 1;
                            tPointer += 1;
                        }
                    }
                } else {
                    int sPointer = 0;
                    int tPointer = 0;
                    boolean unequal = false;
                    while (sPointer < s.length()) {
                        if(t.charAt(tPointer) != s.charAt(sPointer)) {
                            tPointer += 1;
                            if(unequal) {
                                return false;
                            } unequal = true;
                        } else {
                            sPointer += 1;
                            tPointer += 1;
                        }
                    }
                }
            }
            return true;
        }
    }
}
