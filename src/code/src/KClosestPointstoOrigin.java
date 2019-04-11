import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    private static class Solution {
        public int[][] kClosest(int[][] points, int K) {

            int[][] answer = new int[K][2];
            int max = -10;
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[2] > o2[2]) {
                            return 1;
                    }
                    if(o1[2] < o2[2]) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            });
            for(int[] point : points) {
                priorityQueue.add(new int[]{point[0], point[1], calculateDifferece(point)});
            }

            for(int i = 0; i<K ; i++) {
                int[] m = priorityQueue.poll();
                answer[i] = new int[]{m[0], m[1]};
            }

            return answer;
        }

        public int calculateDifferece(int[] a) {
            return (a[0]*a[0]) + (a[1]*a[1]);
        }
    }
}
