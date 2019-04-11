package code;

import java.util.HashMap;

public class FindtheTownJudge {

    public static void main(String[] args) {

    }
    static class Solution {
        public int findJudge(int N, int[][] trust) {
            HashMap<Integer, Integer> counts = new HashMap<>();

            for(int i = 1; i <= N; i++) {
                counts.put(i,0);
            }

            for(int i = 0; i < trust.length; i++) {
                int[] data = trust[i];
                counts.put(data[i], counts.get(data[1]) + 1);
            }

            for(int i : counts.keySet()) {
                if(counts.get(i) == N-1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
