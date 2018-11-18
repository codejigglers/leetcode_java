package code;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.print(solution.restoreIpAddresses("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));

    }

    private static class Solution{
        public List<String> restoreIpAddresses(String s) {
            ArrayList<String> answer = new ArrayList<>();

            helperFunction(s, 0, answer, 0, 3, "");

            return answer;
        }

        public List<String> helperFunction(String s, int depth, ArrayList<String> answer, int start, int end, String strs) {

            if(depth>3){
                return null;
            }
            for(int i=start; i<=end; i++ ) {
                if (i < s.length()) {
                    if (isValid(slice_range(s, start, i+1))) {
                        if (i == s.length() - 1 && depth == 3) {
                            answer.add(strs + (slice_range(s, start, i+1)));
                        }
                        helperFunction(s, depth + 1, answer, i+1, i+3, strs + slice_range(s, start, i+1) + ".");
                    }
                }
            }

            return answer;
        }

        public String slice_range(String s, int startIndex, int endIndex) {
            if (startIndex < 0) startIndex = s.length() + startIndex;
            if (endIndex < 0) endIndex = s.length() + endIndex;
            return s.substring(startIndex, endIndex);
        }

        public boolean isValid(String string){
            if(Integer.parseInt(string)>=0 && Integer.parseInt(string)<=255 && !(string.startsWith("0") && string.length()>1)){
                return true;
            }
            return false;
        }
    }
}
