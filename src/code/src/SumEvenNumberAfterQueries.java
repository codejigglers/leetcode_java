public class SumEvenNumberAfterQueries {

    public static void main(String[] args) {

    }


    public static class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

            int[] m = new int[A.length];
            int evens = 0;
            for(int i : A) {
                if(i%2==0) {
                    evens+=i;
                }
            }

            for(int i=0; i<queries.length; i++) {
                int index = queries[i][1];
                int val = queries[i][0];

                if((A[index] + val) % 2 == 0) {
                    if(A[index]%2==0) {
                        evens += val;
                    }
                    else {
                        evens+=A[index] + val;
                    }
                }
                else {
                    if(A[index]%2==0) {
                        evens -= A[index];
                    }
                }
                m[i] = evens;
                A[index] = A[index] + val;
            }

        return m;

        }
    }
}
