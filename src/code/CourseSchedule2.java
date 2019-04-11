package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findOrder(2, new int[][]{{0,1},{1,0}});
    }

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            boolean[] visited = new boolean[numCourses];
            Boolean[] isCycle = new Boolean[]{false};
            ArrayList<Integer> finalStack = new ArrayList<>();
            HashMap<Integer, Integer> unvisited = new HashMap();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                unvisited.put(i, 0);
                map.put(i, new ArrayList<Integer>());
            }


            for (int[] dep : prerequisites) {
                if (map.containsKey(dep[1])) {
                    map.get(dep[1]).add(dep[0]);
                } else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(dep[0]);
                    map.put(dep[1], a);
                }
            }

            while (unvisited.size() > 0) {
                HashSet<Integer> currentVisited = new HashSet<>();
                int start = 0;
                for (Integer key : unvisited.keySet()) {
                    start = key;
                    break;
                }
                topologicalSort(unvisited, map, start, finalStack, currentVisited, isCycle);
            }

            int[] answer = new int[numCourses];
            Collections.reverse(finalStack);
            for(int i = 0; i < numCourses; i++) {
                answer[i] = finalStack.get(i);
            }
            if(isCycle[0]) {
                return new int[]{};
            }
            return answer;
        }

        public void topologicalSort(HashMap<Integer, Integer> unvisited, HashMap<Integer, ArrayList<Integer>> map, int node, ArrayList<Integer> finalStack, HashSet<Integer> currentVisited, Boolean[] isCycle) {
            currentVisited.add(node);
            unvisited.remove(node);
            for(Integer a : map.get(node)) {
                if(currentVisited.contains(a)) {
                    isCycle[0] = true;
                }
                if(unvisited.containsKey(a)) {
                    topologicalSort(unvisited, map, a, finalStack, currentVisited, isCycle);
                }
            }

            finalStack.add(node);

        }
    }
}
