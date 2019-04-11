public class MaxIncreasetoKeepCitySkyline {

    public static void main(String[] args) {
        int[][] cityMap = new int[][]{{3, 0, 8, 4},
                                      {2, 4, 5, 7},
                                      {9, 2, 6, 3},
                                      {0, 3, 1, 0}};

        Solution solution = new Solution();

        System.out.println(solution.maxIncreaseKeepingSkyline(cityMap));
    }

    private static class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {

            if(grid.length == 0) {
                return 0;
            }

            if(grid[0].length == 0) {
                return 0;
            }
            int[] top = new int[grid.length];
            int[] left = new int[grid[0].length];
            int sums = 0;

            for (int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    top[j] = Math.max(top[j], grid[i][j]);
                    left[i] = Math.max(left[i], grid[i][j]);
                }
            }

            for (int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    sums = sums + (Math.min(left[i], top[j]) - grid[i][j]);
                }
            }

            return sums;
        }
    }
}
