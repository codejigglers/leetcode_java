package code;

public class CalculateSqrt {

    public static void main(String[] args) {

    }

    static class Solution {
        public int mySqrt(int x) {
            if(x == 0) {
                return 0;
            } else if(x <= 3) {
                return 1;
            }

            int start = 1;
            int end = x;

            //Binary Search

            while(start <= end) {
                int mid = end - (end - start)/2;

                if(Integer.MAX_VALUE/mid < mid || mid * mid > x) {
                    end = mid - 1;
                } else if(Integer.MAX_VALUE/mid < mid || mid * mid < x) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            return end;

        }
    }
}
