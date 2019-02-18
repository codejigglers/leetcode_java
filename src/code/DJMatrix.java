package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DJMatrix {

    public static void main(String[] args) {
        System.out.println(counterMatches(new ArrayList<>(Arrays.asList("11011",
                                                                        "11111",
                                                                        "00000")),

                                           new ArrayList<>(Arrays.asList("11011",
                                                                         "11111"))));
    }

    public static int counterMatches(List<String> grid1, List<String> grid2) {

        List<char[]> list1 = new ArrayList<>();
        List<char[]> list2 = new ArrayList<>();
        int count = 0;

        for (String s : grid1) {
            list1.add(s.toCharArray());
        }

        for (String s : grid2) {
            list2.add(s.toCharArray());
        }

        List<boolean[]> visited = new ArrayList<>();

        for (int x = 0; x < list1.size(); x++) {
            for (int y = 0; y < list1.get(0).length; y++) {

                boolean[] a = new boolean[]{true};
                if (list1.get(x)[y] == '#' || list1.get(x)[y] == '0') {
                    continue;
                } else if (list1.get(x)[y] != '1') {

                } else if (list1.get(x)[y] == '1') {
                    if (helperMethod(list1, list2, x, y, list1.size(), list1.get(0).length, a)) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public static boolean helperMethod(List<char[]> list1, List<char[]> list2, int x, int y, int maxx, int maxy, boolean[] fin) {

        int[] xa = new int[]{0, 1, 0, -1};
        int[] ya = new int[]{1, 0, -1, 0};

        if (list1.get(x)[y] != list2.get(x)[y]) {
            fin[0] &= false;
        }
        if (list1.get(x)[y] == '1') {
            list1.get(x)[y] = '#';
        }
        if (!isValid(list1, list2, x, y, maxx, maxy)) {
            fin[0] = false;
        }

        for (int i = 0; i < xa.length; i++) {
            if (x + xa[i] < maxx && x + xa[i] >= 0 && y + ya[i] < maxy && y + ya[i] >= 0) {

                if (list1.get(x + xa[i])[y + ya[i]] == '#') {
                    continue;
                } else if (list1.get(x + xa[i])[y + ya[i]] == list2.get(x + xa[i])[y + ya[i]] && list1.get(x + xa[i])[y + ya[i]] == '1') {
                    helperMethod(list1, list2, x + xa[i], y + ya[i], maxx, maxy, fin);
                } else if (list1.get(x + xa[i])[y + ya[i]] != list2.get(x + xa[i])[y + ya[i]] && list1.get(x + xa[i])[y + ya[i]] == '1') {
                    fin[0] = false;
                    helperMethod(list1, list2, x + xa[i], y + ya[i], maxx, maxy, fin);
                } else if (list1.get(x + xa[i])[y + ya[i]] == list2.get(x + xa[i])[y + ya[i]] && list1.get(x + xa[i])[y + ya[i]] == '0') {
                    continue;
                }
            }
        }
        return fin[0];
    }

    public static boolean isValid(List<char[]> list1, List<char[]> list2, int x, int y, int maxx, int maxy) {
        int[] xa = new int[]{0, 1, 0, -1};
        int[] ya = new int[]{1, 0, -1, 0};

        for (int i = 0; i < xa.length; i++) {
            if (x + xa[i] < maxx && x + xa[i] >= 0 && y + ya[i] < maxy && y + ya[i] >= 0) {
                if (!(list1.get(x + xa[i])[y + ya[i]] == list2.get(x + xa[i])[y + ya[i]] || (list2.get(x + xa[i])[y + ya[i]] == '1' && list1.get(x + xa[i])[y + ya[i]] == '#'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
