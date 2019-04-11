import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AkashQ2 {


    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("push");
        a.add("push");
        a.add("push");
        a.add("pop");
        List<Integer> as = new ArrayList<>();
        as.add(1);
        as.add(2);
        as.add(5);
        as.add(5);

        for (long i : maxMin(a,as)) {
            System.out.println(i);
        }
    }

    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        // Write your code here


        List<Long> answer = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) {
                    return 1;
                }
                else if(o1<o2) {
                    return -1;
                }

                else {
                    return 0;
                }
            }
        });


        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) {
                    return -1;
                }
                else if(o1<o2) {
                    return 1;
                }

                else {
                    return 0;
                }
            }
        });

        for(int i =0 ; i<operations.size(); i++) {
            if(operations.get(i).equals("push")) {
                priorityQueue.add(x.get(i));
                priorityQueue2.add(x.get(i));

                answer.add((long) priorityQueue.peek() * (long) priorityQueue2.peek());
            }

            else {
                priorityQueue.remove(x.get(i));
                priorityQueue2.remove(x.get(i));

                answer.add((long) priorityQueue.peek() * (long) priorityQueue2.peek());

            }
        }

        return answer;
    }
}
