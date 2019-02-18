package code;

import java.util.*;

public class DivyaIntuit {

    public static class Solution {

        public static void main(String[] args) {
//            List<String> a = Arrays.asList(new String[]{"Paul","1355"});
//            List<String> b = Arrays.asList(new String[]{"Paul", "1430"});
//            List<String> c = Arrays.asList(new String[]{"Radhika", "1800"});
//            List<String> d = Arrays.asList(new String[]{"Paul", "1456"});
//            List<String> e = Arrays.asList(new String[]{"Paul", "1517"});
//
            List<List<String>> input = new ArrayList<>();
//            in.add(a);
//            in.add(b);
//            in.add(c);
//            in.add(d);
//            in.add(e);
            input.add(new ArrayList<>(Arrays.asList("Paul", "1400")));
            input.add(new ArrayList<>(Arrays.asList("Paul", "1355")));
//          input.add(new ArrayList<>(Arrays.asList("Paul", "1555")));
            input.add(new ArrayList<>(Arrays.asList("Paul", "1454")));

            input.add(new ArrayList<>(Arrays.asList("Paul", "1355")));
            input.add(new ArrayList<>(Arrays.asList("Jennifer", "1910")));
            input.add(new ArrayList<>(Arrays.asList("John", "830")));
            input.add(new ArrayList<>(Arrays.asList("Paul", "1315")));
            input.add(new ArrayList<>(Arrays.asList("John", "835")));
            input.add(new ArrayList<>(Arrays.asList("Paul", "1405")));
            input.add(new ArrayList<>(Arrays.asList("Paul", "1630")));
            input.add(new ArrayList<>(Arrays.asList("John", "855")));
            input.add(new ArrayList<>(Arrays.asList("John", "930")));
            input.add(new ArrayList<>(Arrays.asList("John", "915")));
            input.add(new ArrayList<>(Arrays.asList("Jennifer", "1335")));
            input.add(new ArrayList<>(Arrays.asList("Jennifer", "730")));
            input.add(new ArrayList<>(Arrays.asList("John", "1630")));

//            input.add(new ArrayList<>(Arrays.asList("Marcel", "2000")));
//            input.add(new ArrayList<>(Arrays.asList("Marcel", "1815")));
//            input.add(new ArrayList<>(Arrays.asList("Marcel", "1855")));

            findFrequentEntries(input);
        }

        public static void findFrequentEntries(List<List<String>> input) {
            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();


            for (List<String> employee : input) {
                if (hashMap.containsKey(employee.get(0))) {
                    hashMap.get(employee.get(0)).add(employee.get(1));
                } else {
                    ArrayList<String> a = new ArrayList<>();
                    a.add(employee.get(1));
                    hashMap.put(employee.get(0), a);
                }
            }

            for (String key : hashMap.keySet()) {
                Collections.sort(hashMap.get(key), new CustomComparator());
            }
            int countinue = 1;
            boolean isPrint = false;
            for (String key : hashMap.keySet()) {
                ArrayList<String> times = hashMap.get(key);
                int j = 0;
                int i = 0;
                int count = 1;
                countinue = 1;
                while (i < times.size() && j < times.size() && countinue == 1) {
                    count = 1;
                    j = i + 1;
                    while (j < times.size()) {
                        if (withinFrame(times.get(i), times.get(j))) {
                            j += 1;
                            count += 1;
                        } else {
                            if (count >= 3) {
                                StringBuilder s = new StringBuilder();
                                s.append(key + ":");
                                while (count > 0) {
                                    s.append(" " + times.get(i));
                                    i += 1;
                                    count -= 1;
                                    countinue = 0;
                                }
                                System.out.println(s.toString());
                                isPrint = true;
                                break;
                            } else {
                                i += 1;
                                count = 1;
                                break;
                            }
                        }
                    }
                    if (count >= 3) {
                        StringBuilder s = new StringBuilder();
                        s.append(key + ":");
                        while (count > 0) {
                            s.append(" " + times.get(i));
                            i += 1;
                            count -= 1;
                            countinue = 0;
                        }
                        isPrint = true;
                        System.out.println(s.toString());
                    }
                }

            }
            if(!isPrint) {
                System.out.println("None");
            }

        }


        public static boolean withinFrame(String first, String second) {
            if (Integer.parseInt(second) - Integer.parseInt(first) < 101) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static class CustomComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                return 1;
            } else if (Integer.parseInt(o1) < Integer.parseInt(o2)) {
                return -1;
            } else return 0;
        }
    }
}
