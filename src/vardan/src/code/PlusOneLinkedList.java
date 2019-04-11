package code;

import vardan.src.code.CustomCollectionsUtility;
import vardan.src.code.CustomCollectionsUtility.ListNode;

public class PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode n = CustomCollectionsUtility.createListNode(new int[]{8,9,9,9});
        Solution solution = new Solution();
        solution.plusOne(n);
    }

    static class Solution {
        public ListNode plusOne() {
            return plusOne();
        }

        public ListNode plusOne(ListNode head) {
            if(head == null) {
                return head;
            }
            int x = helperMethod(head);
            if(x == 1) {
                ListNode n = new ListNode(x);
                n.next = head;
                return n;
            }
            return head;

        }

        public int helperMethod(ListNode head) {
            if(head.next == null) {
                int carry = 0;
                if(head.val == 9) {
                    carry = 1;
                }
                head.val = (head.val + 1) % 10;
                return carry;
            } else {
                int x = helperMethod(head.next);
                int carry = (head.val + x) / 10;
                head.val = (head.val + x) % 10;
                return carry;

            }
        }
    }
}
