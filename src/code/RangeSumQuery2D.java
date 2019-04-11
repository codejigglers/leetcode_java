package code;

public class RangeSumQuery2D {

    public static void main(String[] args) {
        int[][] a = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(a);
        numMatrix.sumRegion(1,1,2,2);
    }

    static class NumMatrix {

        int[][] input;

        public NumMatrix(int[][] matrix) {
            this.input = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int[][] dp = new int[input.length + 1][input[0].length + 1];

            for(int i = 0; i < input.length; i++) {
                for(int j = 0; j < input[0].length; j++) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + input[i][j] - dp[i][j];
                }
            }

            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }
}
