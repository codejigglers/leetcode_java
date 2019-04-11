package code;

public class Matrix01SecondApproach {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.updateMatrix(new int[][]{{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}});
    }

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {

            int[][] answer = new int[matrix.length][matrix[0].length];

            if(matrix.length == 0 || matrix[0].length == 0) {
                return answer;
            }

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    answer[i][j] = Integer.MAX_VALUE - 1;
                }
            }

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    helperMethod(i, j, matrix, answer);
                }
            }

            for(int i = matrix.length - 1; i >= 0; i--) {
                for(int j = matrix[0].length - 1; j >= 0; j--) {
                    helperMethod(i, j, matrix, answer);
                }
            }

            return answer;
        }

        public static void helperMethod(int x, int y, int[][] matrix, int[][] answer) {


            if(matrix[x][y] == 0) {
                answer[x][y] = 0;
                return;
            }
            int[] xC = new int[]{1, 0, -1, 0};
            int[] yC = new int[]{0, -1, 0, 1};

            for(int k = 0; k < 4; k++) {
                if((xC[k] + x) >= 0 && (xC[k] + x < matrix.length) && (yC[k] + y >=0) && (yC[k] + y < matrix[0].length)) {
                    if(answer[xC[k] + x][xC[k] + x] + 1 < answer[x][y]) {
                        answer[x][y] = answer[xC[k] + x][xC[k] + x] + 1;
                    }
                }
            }

        }

    }
}
