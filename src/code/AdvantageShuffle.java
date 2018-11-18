package code;

import java.util.Arrays;
import java.util.HashMap;

public class AdvantageShuffle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{2,7,11,15};
        int[] b = new int[]{1,10,4,11};

        int[] g = solution.advantageCount(a,b);

        for (int p=0; p<g.length; p++){
            System.out.println(g[p]);
        }
    }

    private static class Solution {
        public int[] advantageCount(int[] A, int[] B) {

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int i=0; i<B.length; i++){
                hashMap.put(B[i], i);
            }

            int[] c = new int[A.length];
            for(int i = 0; i<A.length; i++){
                c[i]=A[i];
            }

            Arrays.sort(c);
            for(int i = 0; i < c.length / 2; i++)
            {
                int temp = c[i];
                c[i] = c[c.length - i - 1];
                c[c.length - i - 1] = temp;
            }
            Arrays.sort(B);
            for(int i = 0; i < B.length / 2; i++)
            {
                int temp = B[i];
                B[i] = B[B.length - i - 1];
                B[B.length - i - 1] = temp;
            }


            int j = 0;
            int i =0;

            while (i<A.length){
                if(c[j] <= B[i]){
                    i+=1;
                    continue;
                }
                else {
                    A[hashMap.get(B[i])] = c[j];
                    i+=1;
                    j+=1;
                }
            }
            i=0;
            if(j<A.length-1){
                while (j<A.length){
                    A[hashMap.get(B[j])] = c[i];
                    i+=1;
                    j+=1;
                }
            }

            return A;
        }
    }
}
