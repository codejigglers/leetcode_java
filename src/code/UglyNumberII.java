package code;

public class UglyNumberII {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1;

            int two = 0;
            int three = 0;
            int five = 0;

            //We are using this method so lets say 4 is one of the ugly number which was formed by 2*2 and is on 4 position, but when we keep on
            //incrementing value of 2,3 and 5 by one, at some stage 3 or 5 pointer would also ome on to 4 index(2*2), where it will multiply it with 3
            //Which is the case that is confusing in this question. Basically, we will also get those numbers which are multiple of 2,3 and 5s.


            for (int i = 1; i < n; i++) {
                ugly[i]=Math.min(ugly[two]*2, Math.min(ugly[three]*3, ugly[five]*5));

                if(ugly[i]==ugly[two]*2){
                    two+=1;
                }
                if(ugly[i]==ugly[three]*2){
                    three+=1;
                }
                if(ugly[i]==ugly[five]*2){
                    five+=1;
                }
            }

            return ugly[n-1];
        }
    }
}
