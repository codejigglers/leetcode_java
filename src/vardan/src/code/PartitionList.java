package code;

import vardan.src.code.CustomCollectionsUtility.ListNode;

public class PartitionList {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(1);
            ListNode big = new ListNode(1);

            ListNode toReturn = small;
            ListNode ref = big;

            while(head != null) {
                if(head.val < x) {
                    small.next = head;
                    head = head.next;
                    small = small.next;
                    small.next = null;
                } else if(head.val >= x) {
                    big.next = head;
                    head = head.next;
                    big = big.next;
                    big.next = null;
                }
            }

            small.next = ref.next;
            return toReturn.next;
        }
    }
}
