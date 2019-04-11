package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IslandProblem {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int matrix[][] = new int[N][M];
        boolean visited[][] = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==1 && visited[i][j]==false) {
                    visited[i][j] = true;
                    int result = calculateIsland(i, j, visited, matrix);
                    ans.add(result);
                }
            }
        }

        Collections.sort(ans);

        for (int i : ans){
            System.out.println(i);
        }

    }

    public static int calculateIsland(int i, int j, boolean[][] visited, int[][] matrix) {
        int result = 1;

        int[] x = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] y = {0, -1, -1, -1, 0, 1, 1, 1};

        for(int k=0; k<x.length; k++) {
            if(i+x[k]<matrix.length && i+x[k]>=0 && j+y[k]<matrix[0].length && j+y[k]>=0 && visited[i+x[k]][j+y[k]]==false && matrix[i+x[k]][j+y[k]]==1 ) {
                visited[i+x[k]][j+y[k]] = true;
                result+=calculateIsland(i+x[k], j+y[k], visited, matrix);
            }
        }

        return result;
    }
}
