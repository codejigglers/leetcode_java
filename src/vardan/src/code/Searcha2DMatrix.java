package code;

public class Searcha2DMatrix {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] a = new int[][] {
                {1}
        };

        solution.searchMatrix(a, 2);

    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if(matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int rowNum = findRow(matrix, target);
            if(rowNum == -1) {
                return false;
            } else {
                int start = 0;
                int end = matrix[0].length - 1;
                while(start <= end) {
                    int mid = (start + end) / 2;
                    if(matrix[rowNum][mid] == target) {
                        return true;
                    } else if(matrix[rowNum][mid] > target) {
                        end = mid - 1;
                    } else if(matrix[rowNum][mid] < target) {
                        start = mid + 1;
                    }
                }
                return false;
            }
        }

        public int findRow(int[][] matrix, int number) {
            int start = 0;
            int end = matrix.length - 1;
            int size = matrix[0].length;

            while(start <= end) {
                int mid = (start + end) / 2;
                if(matrix[mid][0] <= number && matrix[mid][size - 1] >= number) {
                    return mid;
                } else if(matrix[mid][0] > number) {
                    end = mid - 1;
                } else if(matrix[mid][size - 1] < number) {
                    start = mid + 1;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }
}
