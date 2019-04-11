public class ValidMountainArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validMountainArray(new int[]{1, 2, 5, 5, 6, 4}));
    }

    static class Solution {
        public boolean validMountainArray(int[] A) {
            if(A.length < 3 || A[0] > A[1]) {
                return false;
            }
            boolean increasing = true;

            for (int i = 2; i < A.length; i++) {
                if(A[i] == A[i-1]) {
                    return false;
                }

                if(A[i] > A[i-1] && !increasing) {
                    return false;
                }
                if(A[i]<A[i-1]) {
                    increasing = false;
                }

            }

            return (!increasing);
        }
    }
}
