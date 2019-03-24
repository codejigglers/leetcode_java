import java.util.ArrayList;
import java.util.List;

public class GenerateParenthsis {

    public static void main(String[] args) {
        Solution solution = new Solution();

        for(String s : solution.generateParenthesis(3)) {
            System.out.println(s);
        }

    }

    public static class Solution {
        public List<String> generateParenthesis(int n) {

            ArrayList<String> answer = new ArrayList<>();

            return (helperMethod(0, 0, new String[n*2], 0, answer, n));
        }

        public static List<String> helperMethod(int openCount, int closeCount, String[] modifiableList, int index, ArrayList<String> answer, int total) {
            if(index == modifiableList.length) {
                answer.add(String.join("", modifiableList));
                return null;
            }

            if(openCount < total) {
                modifiableList[index] = "(";
                helperMethod(openCount + 1, closeCount, modifiableList, index + 1, answer, total);

            }
            if(closeCount<openCount) {
                modifiableList[index] = ")";
                helperMethod(openCount, closeCount + 1, modifiableList, index + 1, answer, total);
            }
            return answer;
        }
    }
}
