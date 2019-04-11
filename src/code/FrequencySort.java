package code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

    public static void main(String[] args) {
        int[] m = new int[]{1,1,1,1,2,3,4};
        sortIt(m);
    }

    public static void sortIt(int[] nums) {

        HashMap<Integer, Integer> pool = new HashMap<>();
        for(Integer item : nums) {
            if(pool.containsKey(item)) {
                pool.put(item, pool.get(item) + 1);
            } else {
                pool.put(item, 1);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]) {
                    return 1;
                } else if(o1[1] < o2[1]) {
                    return -1;
                } else if(o1[0] > o2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for(int key : pool.keySet()) {
            pq.add(new int[]{key, pool.get(key)});
        }

        int l = 0;
        while (pq.size() > 0) {
            int[] x = pq.poll();
            for(int i = 0; i<x[1]; i++) {
                nums[l] = x[0];
                l += 1;
            }
        }

        System.out.println("SS");
    }
}
