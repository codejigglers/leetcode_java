package code;

import java.util.HashMap;

public class RomantoInteger {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("IV"));
    }

    static class Solution {
        public int romanToInt(String s) {

            int answer = 0;
            HashMap<Character, Integer> values = new HashMap<>();
            values.put('I', 1);
            values.put('V', 5);
            values.put('X', 10);
            values.put('L', 50);
            values.put('C', 100);
            values.put('D', 500);
            values.put('M', 1000);


            int i = s.length() - 1;
            while (i >= 0) {
                if(s.charAt(i) == 'I') {
                    answer+=1;
                    i-=1;
                    continue;
                }
                if(s.charAt(i) == 'V' || s.charAt(i) == 'X') {
                    if(i>0 && s.charAt(i-1) == 'I') {
                        answer+=(values.get(s.charAt(i)) - 1);
                        i-=2;
                    } else {
                        answer+=values.get(s.charAt(i));
                        i-=1;
                    }
                    continue;
                }

                if(s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                    if(i>0 && s.charAt(i-1) == 'X') {
                        answer+=(values.get(s.charAt(i)) - 10);
                        i-=2;
                    } else {
                        answer+=values.get(s.charAt(i));
                        i-=1;
                    }
                    continue;
                }

                if(s.charAt(i) == 'D' || s.charAt(i) == 'M') {
                    if(i>0 && s.charAt(i-1) == 'C') {
                        answer+=(values.get(s.charAt(i)) - 100);
                        i-=2;
                    } else {
                        answer+=values.get(s.charAt(i));
                        i-=1;
                    }
                    continue;
                }
            }

            return answer;
        }
    }
}
