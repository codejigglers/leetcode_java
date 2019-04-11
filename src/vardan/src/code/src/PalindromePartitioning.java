import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<String>> ans = solution.partition("AAAB");
        System.out.println("AAAA");
    }

    private static class Solution {
        public ArrayList<ArrayList<String>> partition(String s) {
            ArrayList<String> answer = new ArrayList<String>();
            ArrayList<ArrayList<String>> finalAns = new ArrayList<>();
            return helperFunction(s, 0, answer, finalAns);
        }

        public ArrayList<ArrayList<String>> helperFunction(String s, int start, List<String> answer, ArrayList<ArrayList<String>> finalAns) {
            for(int i = start; i<s.length(); i++) {
                if(isPalindrome(s.substring(start, i + 1))){
                    answer.add(s.substring(start, i + 1));
                    if(i==s.length()-1){
                        finalAns.add(new ArrayList<>(answer));
                    }
                    else {
                        helperFunction(s, i + 1, answer, finalAns);
                    }
                    answer.remove(answer.size() - 1);
                }
            }
            return finalAns;
        }

        public boolean isPalindrome(String data) {
            int start = 0;
            int end = data.length() - 1;

            while (start <= end) {
                if (data.charAt(start) != data.charAt(end)) {
                    return false;
                } else {
                    start += 1;
                    end -= 1;
                }
            }
            return true;
        }
    }
}
