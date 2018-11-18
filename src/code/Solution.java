package code;

public class Solution {

    public static void main(String[] args){
        solution(2,"1A 2F 1C");
    }

    public static int solution (int N, String S) {

        boolean[][] matrix = new boolean[N][12];

        int ans  = 0;

        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<12; j++){
                if(j==3 || j==8){
                    matrix[i][j] = true;
                }
            }
        }

        String[] breaks = S.split(" ");

        for(String s:breaks){
            int row = Integer.parseInt(s.substring(0, s.length() - 1));
            int col = (s.charAt(s.length()-1) - 'A');

            if(col>2 && col<7){
                col=col+1;
            }
            else if(col>6){
                col=col+2;
            }

            matrix[row - 1][col] = true;
        }

        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<12; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<12; j++){
                if(j<10 && !matrix[i][j]){
                    if(!matrix[i][j+1] && !matrix[i][j+2]){
                        ans+=1;
                        j+=3;
                    }
                }
            }

        }
        return ans;

    }
}
