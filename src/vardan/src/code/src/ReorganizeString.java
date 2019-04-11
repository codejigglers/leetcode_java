import java.util.*;

public class ReorganizeString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.reorganizeString("aaabb"));
    }

    private static class StrCount {
        Character c;
        Integer i;

        public StrCount(Character c, Integer i) {
            this.c = c;
            this.i = i;
        }

    }

    private static class Solution {
        public String reorganizeString(String S) {

            Character[] array = new Character[S.length()];

            HashMap<Character, Integer> hashMap = new HashMap<>();

            //Populating hashmap with count
            for (int i = 0; i < S.length(); i++) {
                if (hashMap.containsKey(S.charAt(i))) {
                    hashMap.put(S.charAt(i), hashMap.get(S.charAt(i)) + 1);
                } else {
                    hashMap.put(S.charAt(i), 1);
                }
            }

            PriorityQueue<StrCount> pq = new PriorityQueue<>(1000, new Comparator<StrCount>() {
                @Override
                public int compare(StrCount o1, StrCount o2) {
                    return o1.i - o2.i;
                }
            });

            for (Character c : hashMap.keySet()) {
                pq.add(new StrCount(c, -hashMap.get(c)));
            }

            int slots = -pq.peek().i;
            int gap = S.length()%2==0? (S.length() / slots)-1:(S.length() / slots) ;
            int count = 0;
            while (!pq.isEmpty()) {
                StrCount strCount = pq.poll();
                if ((S.length() % 2 == 0 && -strCount.i > S.length() / 2) || (S.length() % 2 == 1 && -strCount.i > (S.length() / 2) + 1)) {
                    return "";
                }
                int m = -strCount.i;

//                int i = 0;
//                i = (array[count] == null) ? 0 + count :1 + count;
                for (int i = 0 + count; i < S.length() && m > 0; i += 1 + gap) {
                    if (array[i] == null) {
                        array[i] = strCount.c;
                        m -= 1;
                    }
                    else {
                        while (array[i]!=null){
                            i+=1;
                        }
                        array[i]=strCount.c;
                        m-=1;
                    }
                }
                count += 1;
            }

            StringBuilder builder = new StringBuilder();
            for (Character s : array) {
                builder.append(s);
            }
            String str = builder.toString();

            return str;

        }
    }

}
