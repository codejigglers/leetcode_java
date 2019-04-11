public class SwatiGoogle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,3,4,5,6,7,9}));
    }

    static class Solution {
        public int solution(int[] A) {

            int start = 0;
            int level = 0;
            int end = -1;
            int max = -Integer.MAX_VALUE;
            int levelAns = -1;

            while (start < A.length) {
                double count = Math.pow(2, level);
                int sum = 0;
                for (int m = end + 1; m< end + 1 + count; m++) {
                    start = m;
                    if(m>=A.length) {
                        break;
                    }
                    sum+=A[m];
                }
                end = end + (int) count;
                if(sum>max) {
                    levelAns = level + 1;
                    max = sum;
                }
                level+=1;

            }
            return levelAns;
        }
    }
}
