package code;


import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class nj {
    public int numUniqueEmails(String[] emails) {

        HashMap<String, Integer> hashSet = new HashMap<>();
        int max = -1;

        for (String each : emails) {
            String[] a = splitter(each);
            String init = a[0];
            String last = a[1];



            StringBuilder stringBuilder = new StringBuilder("");
            for(int i=0; i<init.length(); i++) {
                if(init.charAt(i) == '.') {
                    continue;
                }
                else if(init.charAt(i) == '+') {
                    break;
                }
                stringBuilder.append(init.charAt(i));
            }

            hashSet.put(stringBuilder.toString().concat(last), hashSet.getOrDefault(stringBuilder.toString().concat(last), 0) + 1);


            }
        for(String s : hashSet.keySet()) {
            max = Math.max(hashSet.get(s), max);
        }
        return max;
    }

    public String[] splitter(String string) {

        String[] answer = new String[2];
        for(int i=0; i<string.length(); i++) {
            if(string.charAt(i) == '@') {
                answer[0] = string.substring(0,i );
                answer[1] = string.substring(i+1, string.length());
            }
        }
        return answer;
    }
}