package code;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {

            StringBuilder builder = new StringBuilder();
            builder.append(nums[0]);
            List<String> answer = new ArrayList<>();
            if(nums.length == 0) {
                return answer;
            } else if(nums.length == 1) {
                builder.append(nums[0]);
                answer.add(builder.toString());
                return answer;
            }
            int start = nums[0];
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] + 1 == nums[i+1]) {
                    if(builder.length() != 0) {
                        continue;
                    } else {
                        builder.append(nums[i]);
                        builder.append("->");
                    }
                } else {
                    builder.append(nums[i]);
                    answer.add(builder.toString());
                    builder = new StringBuilder();
                }
            }

            builder.append(nums[nums.length - 1]);
            answer.add(builder.toString());
            return answer;
        }
    }

}
