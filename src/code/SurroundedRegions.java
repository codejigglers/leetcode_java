package code;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }

    static class Solution {
        public void solve(char[][] board) {

            if(board.length == 0 || board[0].length == 0) {
                return;
            }

            boolean[][] finalAns = new boolean[board.length][board[0].length];
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && !visited[i][j]) {
                        helperFunction(i, j, board, visited, finalAns);
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (finalAns[i][j] == true) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }

                }
            }
        }


        public static void helperFunction(int x, int y, char[][] board, boolean[][] visited, boolean[][] finalAns) {
            int[] xC = new int[]{1, 0, -1, 0};
            int[] yC = new int[]{0, -1, 0, 1};
            visited[x][y] = true;
            finalAns[x][y] = true;
            for (int i = 0; i < 4; i++) {
                if (x + xC[i] >= 0 && x + xC[i] < visited.length && y + yC[i] >= 0 && y + yC[i] < visited[0].length && board[x + xC[i]][y + yC[i]] == 'O' && !visited[x + xC[i]][y + yC[i]]) {
                    finalAns[x + xC[i]][y + yC[i]] = true;
                    helperFunction(x + xC[i], y + yC[i], board, visited, finalAns);
                }
            }
        }
    }


}
