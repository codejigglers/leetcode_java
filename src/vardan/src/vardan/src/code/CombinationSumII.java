package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            List<List<Integer>> answer = new ArrayList<>();
            if(candidates==null || candidates.length==0) {
                return answer;
            }
            List<Integer> mid = new ArrayList<>();
            Arrays.sort(candidates);
            helperMethod(0, target, answer, candidates, mid);
            return answer;

        }

        public void helperMethod(int index, int target, List<List<Integer>> answer, int[] candidates, List<Integer> mid) {
            for (int i = index; i < candidates.length; i++) {
                if (i > 0 && i>index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (target - candidates[i] < 0) {
                    break;
                } else if (target - candidates[i] == 0) {
                    mid.add(candidates[i]);
                    answer.add(new ArrayList<>(mid));
                    helperMethod(i + 1, target - candidates[i], answer, candidates, mid);
                    mid.remove(mid.size() - 1);
                } else {
                    mid.add(candidates[i]);
                    helperMethod(i + 1, target - candidates[i], answer, candidates, mid);
                    mid.remove(mid.size() - 1);
                }
            }
        }
    }
}
