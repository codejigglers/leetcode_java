package code;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {


            Queue<int[]> queue = new LinkedList<>();
            int[][] answer = new int[matrix.length][matrix[0].length];

            if(matrix.length == 0 || matrix[0].length == 0) {
                return answer;
            }

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    answer[i][j] = Integer.MAX_VALUE;
                    if(matrix[i][j] == 0) {
                        queue.add(new int[]{i, j, 0});
                        answer[i][j] = 0;
                    }
                }
            }

            int[] x = new int[]{1, 0, -1, 0};
            int[] y = new int[]{0, -1, 0, 1};

            while (queue.size() > 0) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int dist = cur[2] + 1;

                for(int i = 0; i < 4; i++) {
                    if((x[i] + curX) >= 0 && (x[i] + curX < matrix.length) && (y[i] + curY >=0) && (y[i] + curY < matrix[0].length)) {
                        if(answer[x[i] + curX][y[i] + curY] > dist) {
                            answer[x[i] + curX][y[i] + curY] = dist;
                            queue.add(new int[]{x[i] + curX, y[i] + curY, dist});
                        }
                    }
                }
            }
            return answer;
        }
    }

}
