import java.util.*;

public class SortingDates {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> q = new ArrayList<>();

        q.add("20 Oct 2052");
        q.add("16 Dec 2012");
        q.add("28 Jul 1963");
        q.add("28 Jul 1963");

        List<String> result = solution.sortDates(q);
        for(String s: result){
            System.out.println(s);
        }
    }

    private static class Solution {

        public static List<String> sortDates(List<String> dates) {

            PriorityQueue<String> pq = new PriorityQueue<>(10, new stringComparator());

            ArrayList<String> answer  = new ArrayList<>();

            for(int i=0; i<dates.size(); i++){
                pq.add(dates.get(i));
            }

            while (!pq.isEmpty()){
                answer.add(pq.poll());
            }

            return answer;
        }
    }

    public static class stringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            HashMap<String, Integer> hash = new HashMap<>();
            hash.put("Jan", 0);
            hash.put("Feb", 1);
            hash.put("Mar", 2);
            hash.put("Apr", 3);
            hash.put("May", 4);
            hash.put("Jun", 5);
            hash.put("Jul", 6);
            hash.put("Aug", 7);
            hash.put("Sep", 8);
            hash.put("Oct", 9);
            hash.put("Nov", 10);
            hash.put("Dec", 11);

            int d1 = Integer.parseInt(o1.split(" ")[0]);
            int m1 = hash.get(o1.split(" ")[1]);
            int y1 = Integer.parseInt(o1.split(" ")[2]);
            int d2 = Integer.parseInt(o2.split(" ")[0]);
            int m2 = hash.get(o2.split(" ")[1]);
            int y2 = Integer.parseInt(o2.split(" ")[2]);

            if(y1>y2){
                return 1;
            }
            else if (y1<y2){
                return -1;
            }
            else {
                if(m1>m2){
                    return 1;
                }
                else if (m1<m2){
                    return -1;
                }
                else {
                    if(d1>d2){
                        return 1;
                    }
                    else if (d1<d2){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }

        }
    }


}
