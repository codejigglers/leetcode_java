import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRoom2 {

    static class Interval {
        int start;
        int end;


        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval[] a = new Interval[3];
        Interval a1 = new Interval(0, 30);
        Interval a2 = new Interval(5, 10);
        Interval a3 = new Interval(15, 20);

        a[0] = a1;
        a[1] = a2;
        a[2] = a3;

        System.out.println(countRooms(a));
    }


    public static int countRooms(Interval[] intervals) {
        Arrays.sort(intervals, new MyComparator());
        int start = 0;
        int end = 0;
        int max = -1;
        int curCount = 0;

        int[] starta = new int[intervals.length];
        int[] enda = new int[intervals.length];


        for(int i = 0; i<intervals.length; i++) {
            starta[i] = intervals[i].start;
            enda[i] = intervals[i].end;
        }

        Arrays.sort(starta);
        Arrays.sort(enda);

        while (start < intervals.length && end < intervals.length) {
            if(starta[start] < enda[end]) {
                curCount += 1;
                max = Math.max(curCount, max);
                start += 1;
                continue;
            } else {
                curCount -= 1;
                end += 1;
            }
        }
        return max;
    }

    static class MyComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval i1, Interval i2) {
            if(i1.start > i2.start) {
                return 1;
            } else if (i1.start < i2.start) {
                return -1;
            } else {
                return 0;
            }

        }
        @Override
        public boolean equals(Object obj) {
            return false;
        }

    }
}
