package code;

import java.util.HashMap;

public class ValidAnagram {

    private static class Solution {
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> hashs = new HashMap<>();

            for(int i = 0; i<s.length(); i++) {
                if(hashs.containsKey(s.charAt(i))) {
                    hashs.put(s.charAt(i), hashs.get(s.charAt(i)) + 1);
                }
                else {
                    hashs.put(s.charAt(i), 1);
                }
            }

            for(int i = 0; i<t.length(); i++) {
                if(hashs.containsKey(t.charAt(i))) {
                    hashs.put(t.charAt(i) , hashs.get(t.charAt(i)) - 1);
                }
                else {
                    return false;
                }
            }

            for(Character c : hashs.keySet()) {
                if(hashs.get(c) != 0) {
                    return false;
                }
            }

            return true;


        }
    }
}
