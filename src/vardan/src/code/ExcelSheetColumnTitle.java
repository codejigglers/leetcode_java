package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.convertToTitle(52));

    }

    private static class Solution {
        public String convertToTitle(int n) {
            StringBuilder sb = new StringBuilder();
            int mid;

            while (n > 0) {
                if (n % 26 == 0) {
                    mid = 26;
                    sb.insert(0, (char) (mid + 'A' - 1));
                    n = (n / 27);
                } else {
                    mid = (n) % 26;
                    sb.insert(0, (char) (mid + 'A' - 1));
                    n = (n / 26);
                }


            }

            return sb.toString();

        }
    }

}

