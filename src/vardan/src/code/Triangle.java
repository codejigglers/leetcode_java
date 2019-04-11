package code;

import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle.size() == 0) {
                return 0;
            } else if(triangle.size() == 1) {
                return triangle.get(0).get(0);
            }
            List<Integer> miniSum = triangle.get(triangle.size() - 1);
            for(int i = 0; i < miniSum.size() - 1; i++) {
                miniSum.set(i, Math.min(miniSum.get(i), miniSum.get(i+1)));
            }
            for(int i = triangle.size() - 2; i >= 0; i--) {
                List<Integer> current = triangle.get(i);
                for(int j = 0; j < current.size() - 1; j++) {
                    miniSum.set(j, Math.min((miniSum.get(j) + current.get(j)), (miniSum.get(j+1) + current.get(j + 1))));
                }
            }
            return miniSum.get(0) + triangle.get(0).get(0);
        }
    }
}
