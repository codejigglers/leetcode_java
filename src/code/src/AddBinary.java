import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddBinary {


    public static class Solution {
        public String addBinary(String a, String b) {
            int carry = 0;

            int p1 = a.length() - 1;
            int p2 = b.length() - 1;
            ArrayList<String> answer = new ArrayList<>();
            while (p1 >= 0 && p2 >= 0) {
                int res = Integer.parseInt(String.valueOf(a.charAt(p1))) + Integer.parseInt(String.valueOf(b.charAt(p2))) + carry;
                answer.add(String.valueOf(res % 2));
                carry = res / 2;
                p1 -= 1;
                p2 -= 1;
            }

            if (p1 < 0 && p2 < 0) {
                if (carry != 0) {
                    answer.add(String.valueOf(1));
                }
                Collections.reverse(answer);
                return String.join("", answer);
            } else if (p1 < 0) {
                while (p2 >= 0) {
                    int m = Integer.parseInt(String.valueOf(b.charAt(p2))) + carry;
                    answer.add(String.valueOf(m % 2));
                    carry = m / 2;
                    p2-=1;
                }
            } else if (p2 < 0) {
                while (p1 >= 0) {
                    int m = Integer.parseInt(String.valueOf(a.charAt(p1))) + carry;
                    answer.add(String.valueOf(m % 2));
                    carry = m / 2;
                    p1-=1;
                }

            }
            if (carry != 0) {
                answer.add(String.valueOf(1));
            }
            Collections.reverse(answer);
            return String.join("", answer);

        }
    }
}
