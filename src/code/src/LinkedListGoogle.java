import java.util.HashMap;

public class LinkedListGoogle {

    public static void main(String[] args) {
        int D = 3;
        int[] A = new int[]{-1, 0, 4, 2, 1};

        Solution solution = new Solution();
        for (int i :solution.solution(D, A)){
            System.out.println(i);
        }



    }

    private static class Solution {
        public int[] solution(int D, int[] A) {

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int i=0; i<A.length; i++) {
                hashMap.put(A[i], i);
            }
            int elem = 0;
            A[0] = -1;
            for(int j=1; j<A.length; j++) {
                A[j] = hashMap.get(elem);
                elem = A[j];
            }
            A[0] = 0;

            int[] answer = new int[A.length];

            for(int h=0; h<A.length; h++) {
                if(h<D){
                    answer[A[h]] = -1;
                }
                else {
                    answer[A[h]] = A[h-D];
                }
            }

            return answer;
        }
    }
}


