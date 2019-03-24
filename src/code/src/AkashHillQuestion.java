import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AkashHillQuestion {

    public static void main(String[] args) {

    }

    public static long climbTheHill(List<Integer> slope) {

        return Math.min(helperMethodDecreasing(slope),  helperMethodIncreasing(slope));
    }

    public static long helperMethodIncreasing(List<Integer> slope) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) {
                    return -1;
                } else if(o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int netSum = 0;

        for (int i = 0; i < slope.size(); i++) {
            if (!pq.isEmpty() && pq.peek() > slope.get(i)) {
                int heightDiff = pq.peek() - slope.get(i);
                netSum += heightDiff;
                pq.poll();
                pq.add(slope.get(i));
            }
            pq.add(slope.get(i));
        }
        return netSum;
    }

    public static long helperMethodDecreasing(List<Integer> slope) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int netSum = 0;

        for (int i = 0; i < slope.size(); i++) {
            if (!pq.isEmpty() && pq.peek() < slope.get(i)) {
                int heightDiff = slope.get(i) - pq.peek();
                netSum += heightDiff;
                pq.poll();
                pq.add(slope.get(i));
            }
            pq.add(slope.get(i));
        }
        return netSum;
    }
}
