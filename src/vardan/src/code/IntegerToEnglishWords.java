package code;

import java.util.HashMap;

public class IntegerToEnglishWords {

    static class Solution {
        public String numberToWords(int num) {

            if(num == 0) {
                return "Zero";
            }
            HashMap<Integer, String> hMap = new HashMap();

            hMap.put(1, "One");
            hMap.put(2, "Two");
            hMap.put(3, "Three");
            hMap.put(4, "Four");
            hMap.put(5, "Five");
            hMap.put(6, "Six");
            hMap.put(7, "Seven");
            hMap.put(8, "Eight");
            hMap.put(9, "Nine");
            hMap.put(10, "Ten");
            hMap.put(100, "Hundred");
            hMap.put(1000, "Thousand");
            hMap.put(1000000, "Million");
            hMap.put(100000000, "Billion");
            hMap.put(11, "Eleven");
            hMap.put(12, "Twelve");
            hMap.put(13, "Thirteen");
            hMap.put(14, "Fourteen");
            hMap.put(15, "Fifteen");
            hMap.put(16, "Sixteen");
            hMap.put(17, "Seventeen");
            hMap.put(18, "Eighteen");
            hMap.put(19, "Nineteen");
            hMap.put(20, "Twenty");
            hMap.put(30, "Thirty");
            hMap.put(40, "Forty");
            hMap.put(50, "Fifty");
            hMap.put(60, "Sixty");
            hMap.put(70, "Seventy");
            hMap.put(80, "Eighty");
            hMap.put(90, "Ninety");

            return helper(num, hMap);

        }

        public String helper(int num, HashMap<Integer, String> hMap) {
            StringBuilder answer = new StringBuilder();

            while(num > 0) {
                if (num >= 100000000) {
                    answer.append(helper(num / 100000000, hMap));
                    answer.append(" ");
                    answer.append("Billion");
                    answer.append(" ");
                    num = num % 100000000;
                    continue;
                } if(num >= 1000000) {
                    answer.append(helper(num / 1000000, hMap));
                    answer.append(" ");
                    answer.append("Million");
                    answer.append(" ");
                    num = num % 1000000;
                    continue;
                } if(num >= 1000) {
                    answer.append(helper(num / 1000, hMap));
                    answer.append(" ");
                    answer.append("Thousand");
                    answer.append(" ");
                    num = num % 1000;
                    continue;
                } if(num >= 100) {
                    answer.append(helper(num / 100, hMap));
                    answer.append(" ");
                    answer.append("Hundred");
                    answer.append(" ");
                    num = num % 100;
                    continue;
                } if(num < 100 && num > 19) {
                    answer.append(helper((num / 10) * 10, hMap));
                    answer.append(" ");
                    num = num % 10;
                    continue;
                } else {
                    answer.append(hMap.get(num));
                    return answer.toString();
                }
            }
            return answer.toString();
        }
    }
}
