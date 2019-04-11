package code;

import javafx.util.Pair;

import java.util.*;

public class EvaluateDivision {

    public static void main(String[] args) {
        String[][] equation = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        Solution solution = new Solution();
        double[] a = solution.calcEquation(equation, values, queries);
        System.out.println(a);
    }

    static class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

            HashMap<String, ArrayList<String[]>> map = new HashMap<>();
            ArrayList<Double> answer = new ArrayList<>();
            for (int i = 0; i < equations.length; i++) {
                String[] pair = equations[i];
                double value = (values[i]);
                double inverse = (double) 1 / value;

                String[] putValue = new String[]{pair[1], String.valueOf(value)};
                String[] putValue2 = new String[]{pair[0], String.valueOf(inverse)};

                if (map.containsKey(pair[0])) {
                    map.get(pair[0]).add(putValue);
                } else {
                    ArrayList<String[]> a = new ArrayList<>();
                    a.add(putValue);
                    map.put(pair[0], a);
                }
                if (map.containsKey(pair[1])) {
                    map.get(pair[1]).add(putValue2);
                } else {
                    ArrayList<String[]> a = new ArrayList<>();
                    a.add(putValue2);
                    map.put(pair[1], a);
                }
            }

            for (String[] query : queries) {
                String start = query[0];
                String end = query[1];

                HashSet<String> visited = new HashSet<>();
                ArrayList<Double> data = new ArrayList<>();

                if (!map.containsKey(start) || !map.containsKey(end)) {
                    answer.add(-1.0);
                    continue;
                }
                answer.add((double)dfs(start, end, map, data, visited)[0]);
            }
            double[] a = new double[answer.size()];
            for (int i = 0; i < a.length; i++) {
                a[i] = answer.get(i);
            }
            return a;
        }

        public Object[] dfs(String start, String end, HashMap<String, ArrayList<String[]>> map, ArrayList<Double> data, HashSet<String> visited) {

            for (String[] neighbour : map.get(start)) {
                if (neighbour[0].equals(end)) {
                    double a = 1;
                    for (double b : data) {
                        a *= b;
                    }
                    a = a * Double.parseDouble(neighbour[1]);

                    return new Object[]{a, true};
                } else {
                    if (!visited.contains(neighbour[0])) {
                        data.add(Double.parseDouble(neighbour[1]));
                        visited.add(neighbour[0]);
                        Object[] d = dfs(neighbour[0], end, map, data, visited);
                        boolean isFound= (boolean)d[1];
                        if(isFound) {
                            return d;
                        }
                        data.remove(data.size() - 1);
                    }
                }
            }
            return new Object[]{-1.0, false};
        }
    }
}
