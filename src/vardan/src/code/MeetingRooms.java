package code;

import java.util.*;

public class MeetingRooms {

    public static void main(String[] args) {

    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    static class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            PriorityQueue<Interval> pq = new PriorityQueue(new Comparator<Interval>(){
                @Override
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
            for(Interval i : intervals) {
                pq.add(i);
            }

            Interval prev = pq.poll();
            while(pq.size() != 0) {
                Interval newInt = pq.poll();
                if(prev.end > newInt.start) {
                    return false;
                }
                prev = newInt;
            }

            return true;
        }
    }
}
