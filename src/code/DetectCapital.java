package code;

public class DetectCapital {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.detectCapitalUse("usa");
    }

    static class Solution {
        public boolean detectCapitalUse(String word) {


            if(word.length() == 0) {
                return true;
            }

            int l = 0;
            boolean flag = word.charAt(0) > 'A' && word.charAt(0) < 'Z';
            if(flag) l = 1;
            for(int i = 1; i < word.length(); i++) {
                if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                    l += 1;
                    if(flag == false) {
                        return false;
                    }
                } else {
                    if(l > 1) {
                        return false;
                    }
                    flag = false;
                }
            }

            return true;
        }
    }
}
