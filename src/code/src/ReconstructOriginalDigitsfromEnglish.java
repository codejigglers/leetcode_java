import java.util.HashMap;

public class ReconstructOriginalDigitsfromEnglish {

    public static void main(String[] args) {

    }

    private static class Solution {
        public String originalDigits(String s) {
            int[] hash = new int[26];
            String[] values = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for(int i=0; i<s.length(); i++){
                hash[s.charAt(i)-'a']+=1;
            }


            return "";

        }

        private String helperFunction(){
            return null;
        }
    }
}
