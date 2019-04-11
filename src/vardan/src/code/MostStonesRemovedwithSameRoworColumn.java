package code;

import java.util.ArrayList;
import java.util.HashMap;

public class MostStonesRemovedwithSameRoworColumn {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int removeStones(int[][] stones) {
            HashMap<Integer, ArrayList<Integer>> x = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> y = new HashMap<>();
            Boolean[] visited = new Boolean[stones.length];

            for (int m = 0; m < stones.length; m++) {
                int[] i = stones[m];
                if (x.containsKey(i[0])) {
                    x.get(i[0]).add(m);
                } else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(m);
                    x.put(i[0], a);
                }
                if (y.containsKey(i[1])) {
                    y.get(i[1]).add(m);
                } else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(m);
                    y.put(i[1], a);
                }
            }

        return 1;
        }
    }
}
