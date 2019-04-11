import java.util.LinkedList;
import java.util.Queue;

public class HinalF5 {

    public static void main(String[] args) {
        System.out.println(minMoves(10, 4, 4, 4, 8));
    }

    static boolean inValid(int x, int y, int N)
    {
        if (x >= 0 && x < N && y >= 0 && y < N)
            return true;
        return false;
    }

    public static int minMoves(int n, int startX, int startY, int endX, int endY) {
        // Write your code here
        int[] init = new int[]{startX, startY};
        int[] reach = new int[]{endX, endY};


        boolean[][] traversed = new boolean[n][n];

        Queue<int[]> queueData = new LinkedList<>();

        traversed[init[0]][init[1]] = true;

        int dx[] = {1, -1, -1, 1, -2, 2, -2, 2};
        int dy[] = {2, 2, -2, -2, 1, 1, -1, -1};

        ((LinkedList<int[]>) queueData).push(new int[]{init[0], init[1], 0});

        while (queueData.size() > 0) {


            int[] p = ((LinkedList<int[]>) queueData).pop();
            int X = p[0];
            int Y = p[1];
            int length = p[2];

            if(X == 3 && Y == 6) {
                System.out.println();
            }
            if(X == reach[0] && Y == reach[1]) {
                return length;
            }

            for (int i = 0; i < 8; i++)
            {
                int x = X + dx[i];
                int y = Y + dy[i];
                if (inValid(x, y, n) && !traversed[x][y]) {
                    traversed[x][y] = true;
                    ((LinkedList<int[]>) queueData).add(new int[]{x, y, length + 1});
                }
            }

        }
        return -1;
    }


}
