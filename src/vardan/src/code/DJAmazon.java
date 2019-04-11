package code;

import java.util.*;

public class DJAmazon {

    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> s =Arrays.asList(new Integer[] {1,2});
        List<Integer> d =Arrays.asList(new Integer[] {3,4});
        List<Integer> f =Arrays.asList(new Integer[] {1,-1});
        a.add(s);
        a.add(d);
        a.add(f);
        for(List<Integer> h : ClosestXDestinations(3, a, 2)) {
            System.out.println(String.valueOf(h.get(0)) + " " + String.valueOf(h.get(1)) );
        }
    }


    public static List<List<Integer>> ClosestXDestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {


        if(numDestinations <= numDeliveries) {
            return allLocations;
        }

        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new CustomComparator());

        for(List<Integer> a : allLocations) {
            priorityQueue.add(a);
        }

        List<List<Integer>> answer = new ArrayList<>();

        while (numDeliveries > 0) {
            answer.add(priorityQueue.poll());
            numDeliveries-=1;
        }
        return answer;


    }



    public static class CustomComparator implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {

            if((o1.get(0)*o1.get(0) + o1.get(1)*o1.get(1)) > (o2.get(0)*o2.get(0) + o2.get(1)*o2.get(1))) {
                return 1;
            }
            else if ((o1.get(0)*o1.get(0) + o1.get(1)*o1.get(1)) < (o2.get(0)*o2.get(0) + o2.get(1)*o2.get(1))) {
                return -1;
            }
            else {
                return 0;
            }

        }

    }
}
