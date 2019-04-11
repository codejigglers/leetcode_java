package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 6));
    }

    private static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> a = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                a.add(i);
            }

            List<Integer> answer = new ArrayList<>();
            helperMethod(a, answer, k);

            StringBuilder b = new StringBuilder();
            for (Integer i : answer) {
                b.append(i);
            }
            return b.toString();
        }

        public void helperMethod(List<Integer> input, List<Integer> answer, int number) {

            if (number == 0) {
                answer.addAll(input);
                return;
            }
            int toDivide = input.size() - 1;
            int a = 1;
            for (int i = 1; i <= toDivide; i++) {
                a *= i;
            }

            int index = (number - 1) / a;
            int p = input.get(index);
            answer.add(p);
            input.remove(input.indexOf(p));


            if (input.size() == 1) {
                answer.add(input.get(0));
                return;
            }

            helperMethod(input, answer, ((number - 1) % a) + 1);
        }
    }
}
