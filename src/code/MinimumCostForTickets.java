package code;

import java.util.HashSet;

/*
[1,4,6,7,8,20]
[2,7,15]
* */
public class MinimumCostForTickets {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }

    public static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[][] matrix = new int[3][days[days.length - 1]];

            HashSet<Integer> day = new HashSet<>();
            for (int i : days) {
                day.add(i);
            }

            if (day.contains(1)) {
                matrix[0][0] = costs[0];
            } else {
                matrix[0][0] = 0;
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0) {
                        if (day.contains(j + 1) && j != 0) {
                            matrix[i][j] = matrix[i][j - 1] + costs[0];
                        } else if (j != 0) {
                            matrix[i][j] = matrix[i][j - 1];
                        }
                    } else if (i == 1) {
                        if(j<7) {
                            if(matrix[i-1][j] < costs[1]) {
                                matrix[i][j] = matrix[i-1][j];
                            }
                            else {
                                matrix[i][j] = costs[1];
                            }
                        }
                        else if (!day.contains(j+1)) {
                            matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]);
                        }
                        else {
                            if(matrix[i-1][j] < (costs[1] + matrix[i][j-7])) {
                                matrix[i][j] = matrix[i-1][j];
                            }
                            else {
                                matrix[i][j] = Math.min(costs[1] + matrix[i][j-7], matrix[i][j-7] + matrix[i-1][j] - matrix[i-1][j-7]);
                            }
                        }
                    }

                    else if(i==2) {
                        if(j<30) {
                            if(matrix[i-1][j] < costs[2]) {
                                matrix[i][j] = matrix[i-1][j];
                            }
                            else {
                                matrix[i][j] = costs[2];
                            }
                        }
                        else {
                            if(matrix[i-1][j] < (costs[2] + matrix[i][j-30])) {
                                matrix[i][j] = matrix[i-1][j];
                            }
                            else {
                                matrix[i][j] = costs[2] + matrix[i][j-30];
                            }
                        }
                    }
                }
            }

            return matrix[2][days[days.length - 1]-1];
        }
    }
}
