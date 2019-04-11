package code;

import java.util.ArrayList;
import java.util.HashMap;

public class YelpQue {

    public static void main(String[] args) {
        Event e1 = new Event("ads", 7, 3);
        Event e2 = new Event("ads", 8, 2);
        Event e3 = new Event("ads", 5, 1);
        Event e4 = new Event("page_views", 11, 2);
        Event e5 = new Event("page_views", 12, 3);
        Event e6 = new Event("photo_views", 10, 3);
        Event e7 = new Event("reviews", 7, 2);

        Event[] in = new Event[]{e1, e2, e3, e4, e5, e6, e7};



        ArrayList<Integer> answer = findInactive(in);
        System.out.println("");
    }


    public static ArrayList<Integer> findInactive(Event[] events) {

        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Integer, Boolean> activeNess = new HashMap<>();
        HashMap<String, HashMap<Integer, ArrayList<Integer>>> jobMatch = new HashMap<>();

        for (Event v : events) {
            activeNess.put(v.bizId, false);
        }

        for (int i = 0; i < events.length; i++) {
            String jobName = events[i].eventType;
            int count = events[i].occurences;
            int biz = events[i].bizId;

            if (jobMatch.containsKey(jobName)) {
                HashMap<Integer, ArrayList<Integer>> companyCountMatch = jobMatch.get(jobName);
                if (companyCountMatch.containsKey(biz)) {
                    companyCountMatch.get(biz).add(count);
                } else {
                    ArrayList<Integer> counts = new ArrayList<>();
                    counts.add(count);
                    companyCountMatch.put(biz, counts);
                }
            } else {
                ArrayList<Integer> counts = new ArrayList<>();
                counts.add(count);
                HashMap<Integer, ArrayList<Integer>> companyCountMatch = new HashMap<>();
                companyCountMatch.put(biz, counts);
                jobMatch.put(jobName, companyCountMatch);
            }
        }

        for (String jobs : jobMatch.keySet()) {
            HashMap<Integer, ArrayList<Integer>> companyStat = jobMatch.get(jobs);

            int count = 0;
            int sum = 0;
            for (int companyName : companyStat.keySet()) {
                count += 1;
                ArrayList<Integer> repetetion = companyStat.get(companyName);
                sum += repetetion.get(0);
            }

            float average = (float) (sum) / (float) count;

            for (int companyName : companyStat.keySet()) {
                ArrayList<Integer> times = companyStat.get(companyName);
                int x = times.get(0);
                if (x >= average) {
                    activeNess.put(companyName, true);
                }
            }
        }

        for (int i : activeNess.keySet()) {
            if (activeNess.get(i)) {
                answer.add(i);
            }
        }

        return answer;
    }


    static class Event {
        String eventType;
        int occurences;
        int bizId;

        public Event(String eventType, int occurences, int bizId) {
            this.eventType = eventType;
            this.occurences = occurences;
            this.bizId = bizId;
        }
    }
}
