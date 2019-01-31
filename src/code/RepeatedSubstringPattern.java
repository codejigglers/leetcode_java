package code;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.repeatedSubstringPattern("abababfeab"));
    }


    //abababfeababababfeab

    private static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            return (s+s).substring(1,2*s.length()-1).contains(s);
        }
    }
}
