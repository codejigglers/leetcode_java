public class InterleavingStrings {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    public static class Solution {
        public boolean isInterleave(String A, String B, String C) {

            int[][] visited = new int[A.length()][B.length()];


            if(A.length() == 0) {
                return B.equals(C);
            }
            if(B.length() == 0) {
                return A.equals(C);
            }

            if(A.length()+B.length() != C.length()) {
                return false;
            }

            for(int i=0; i<visited.length; i++) {
                for(int j=0; j<visited[0].length; j++) {
                    visited[i][j] = -1;
                }
            }
            if(helperMethod(0, 0, 0, A, B, C, visited)) {
                return true;
            }
            return false;
        }

        public boolean helperMethod(int aStart, int bStart, int cStart, String A, String B, String C, int[][] visited ) {
            boolean x = false;

            if(visited[aStart][bStart] >= 0) {
                if(visited[aStart][bStart] == 0) {
                    return false;
                } else {
                    return true;
                }
            }

            if(cStart == C.length() - 1) {
                if(aStart >= A.length() && C.charAt(cStart) == B.charAt(bStart)){
                    return true;
                } else if(bStart >= B.length() && C.charAt(cStart) == A.charAt(aStart)) {
                    return true;
                } else {
                    return false;
                }
            }
            if(aStart<A.length() && A.charAt(aStart) == C.charAt(cStart)) {
                x |= helperMethod(aStart + 1, bStart, cStart + 1, A, B, C, visited);
            }
            if(bStart<B.length() && B.charAt(bStart) == C.charAt(cStart)) {
                x |= helperMethod(aStart, bStart + 1, cStart + 1, A, B, C, visited);
            }
            if(x) {
                visited[aStart][bStart] = 1;
            } else {
                visited[aStart][bStart] = 0;
            }
            return x;
        }
    }

}
