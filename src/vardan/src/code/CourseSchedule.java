package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1,0}, {0,1}}));
    }

    private static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for (int[] i : prerequisites) {
                int toTake = i[0];
                int preReq = i[1];

                if(map.containsKey(toTake)) {
                    map.get(toTake).add(preReq);
                }
                else {
                    List<Integer> a = new ArrayList<>();
                    a.add(preReq);
                    map.put(toTake, a);
                }
                if(!map.containsKey(preReq)) {
                    map.put(preReq, new ArrayList<>());
                }

            }

            HashSet<Integer> visited = new HashSet<>();
            HashSet<Integer> chain = new HashSet<>();

            for(int i : map.keySet()) {
                chain.clear();
                if(visited.contains(i)) {
                    continue;
                }
                chain.add(i);
                if(!this.helperMethod(visited, chain, i, map)) {
                    return false;
                }
            }

            return true;
        }


        public boolean helperMethod(HashSet<Integer> visited, HashSet<Integer> chain, int number, HashMap<Integer, List<Integer>> map) {
            for(int i : map.get(number)) {
                if(visited.contains(i) && chain.contains(i)) {
                    return false;
                }
                else if (visited.contains(i)) {
                    continue;
                }
                else {
                    chain.add(i);
                    visited.add(i);
                    return this.helperMethod(visited, chain, i, map);
                }
            }
            return true;
        }
    }
}
