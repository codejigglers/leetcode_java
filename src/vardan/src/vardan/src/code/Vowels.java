package code;

import java.util.*;

public class Vowels {

    public static void main(String[] args) {
        Vowels vowels = new Vowels();
        ArrayList<String> ans = new ArrayList<>();
        ans.add("aba");
        ans.add("bcb");
        ans.add("ece");
        ans.add("aa");
        ans.add("e");

        ArrayList<String> query = new ArrayList<>();
        query.add("1-3");
        query.add("2-5");
        query.add("2-2");
        System.out.println(vowels.hasVowels(ans, query));
    }

    static List<Integer> hasVowels(List<String> strArr, List<String> query){

        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Integer> sums = new ArrayList<>();

        int sum = 0;
        for(String a : strArr){
            if(isVowel(a)){
                sum+=1;
                sums.add(sum);
            }
            else {
                sums.add(sum);
            }
        }


        for(String s : query) {
            int start = Integer.parseInt(s.split("-")[0]);
            int end = Integer.parseInt(s.split("-")[1]);

            start = start - 2;
            end = end - 1;

            if(start<0){
                ans.add(sums.get(end));
            }
            else {
                ans.add(sums.get(end) - sums.get(start));
            }
        }



        return ans;
    }


    public static Boolean isVowel(String str){
        int end = str.length() - 1;

        Set<Character> s = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        if(s.contains(str.charAt(0)) && s.contains(str.charAt(end))){
            return true;
        }
        return false;
    }
}
