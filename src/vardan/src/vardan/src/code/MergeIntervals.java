package vardan.src.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1,3));
        a.add(new Interval(2,6));
        a.add(new Interval(8,10));
        a.add(new Interval(15,18));
        solution.merge(a);
    }

    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {

            PriorityQueue<Interval> p = new PriorityQueue<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if(o1.start > o2.start) {
                        return 1;
                    } else if(o1.start < o2.start) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for(Interval i : intervals) {
                p.add(i);
            }

            List<Interval> answer = new ArrayList<>();
            answer.add(p.poll());
            while (p.size() > 0) {
                Interval newInterval = p.poll();
                Interval existing = answer.get(answer.size() - 1);

                if(existing.end >= newInterval.start) {
                    existing.end = Math.max(newInterval.end, existing.end);
                } else {
                    answer.add(newInterval);
                }
            }

            return answer;
        }
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
