package code;

import java.util.Arrays;
import java.util.Collections;

public class FriendsOfAppropriateAges {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numFriendRequests(new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110});
    }

    static class Solution {
        public int numFriendRequests(int[] ages) {
            int max = Integer.MIN_VALUE;
            int ans = 0;
            for(int i = 0; i < ages.length; i++) {
                if(ages[i] > max) {
                    max = ages[i];
                }
            }
            int[] dp = new int[max];
            for(int i = 0; i < ages.length; i++) {
                dp[ages[i] - 1] += 1;
            }

            for(int i = 0; i < max; i++) {
                int count1 = dp[i];
                if(count1 == 0) {
                    continue;
                }
                for(int j = 0; j < max; j++) {
                    int count2 = dp[j];
                    if(count2 == 0) {
                        continue;
                    }
                    if(i == j) {
                        System.out.println(count1 * (count1 - 1));
                        ans += count1 * (count1 - 1);
                    } else {
                        if((i+1) < (j+1)) continue;
                        if((i+1) < 100 && (j+ 1) > 100) continue;
                        if(((double)j+1) <= (0.5 * ((double)i+1) + 7)) continue;
                        ans += count1 * count2;
                        System.out.println(count1 * count2);
                    }

                }
            }
            return ans;
        }
    }
}
