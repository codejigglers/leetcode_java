package code;

import java.util.Arrays;
import java.util.Comparator;

public class Max_length_of_pair_chain {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}});
    }

    static class Solution {
        public int findLongestChain(int[][] pairs) {
            if(pairs.length == 0) {
                return 0;
            }
            Arrays.sort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int count = 1;
            int max = pairs[0][1];
            for(int i = 1; i < pairs.length; i++) {
                if(pairs[i][0] > max ) {
                    count++;
                    max = pairs[i][1];
                }
            }

            return count;
        }
    }
}
