package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class InsertInterval {

    public static void main(String[] args) {
        MergeIntervals.Solution solution = new MergeIntervals.Solution();
        List<MergeIntervals.Interval> a = new ArrayList<>();
        a.add(new MergeIntervals.Interval(1,3));
        a.add(new MergeIntervals.Interval(2,6));
        a.add(new MergeIntervals.Interval(8,10));
        a.add(new MergeIntervals.Interval(15,18));
        solution.merge(a);
    }

    static class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newIntervals) {

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
            p.add(newIntervals);

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
