package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiPermutation {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[] { 1,2,3});
        List<Integer> b = Arrays.asList(new Integer[] { 1,2,3});
        List<Integer> c = Arrays.asList(new Integer[] { 1,2,3});

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        lists.add(c);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = Arrays.asList(new Integer[] { 1,2,3});

        allCombination(lists, result, 0, current);
        System.out.println();
    }

    public static void allCombination(List<List<Integer>> Lists, List<List<Integer>> result, int depth, List<Integer> current)
    {
        if(depth == Lists.size())
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < Lists.get(depth).size(); ++i)
        {
            current.set(depth, Lists.get(depth).get(i));
            allCombination(Lists, result, depth + 1, current);
        }
    }
}
