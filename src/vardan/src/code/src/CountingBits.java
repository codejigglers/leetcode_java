import java.util.HashMap;

public class CountingBits {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countBits(4);
    }

    private static class Solution {
        public int[] countBits(int num) {
            int[] answer = new int[num + 1];
            if (num == 0) {
                return answer;
            }

            int max = 1;
            answer[1] = 1;

            for (int i = 2; i <= num; i++) {
                if (i == max * 2) {
                    answer[i] = 1;
                    max = i;
                } else {
                    answer[i] = answer[max] + answer[i - max];
                }
            }
            return answer;
        }
    }

}
