package code;

import java.awt.*;
import java.util.Collections;
import java.util.Stack;

public class OneThreeTwoPattern {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('2') - Integer.valueOf('0'));
    }

    static class Solution {
        public boolean find132pattern(int[] nums) {

            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < nums.length; i++) {
                if(stack.size() == 0) {
                    stack.push(nums[i]);
                } else {

                }
            }

            return true;
        }
    }
}
