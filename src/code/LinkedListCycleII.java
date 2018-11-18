package code;

public class LinkedListCycleII {

    public static void main(String[] args) {

    }

    private static class Solution {
        public ListNode detectCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;



            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if(slow.equals(fast)){
                    fast = head;

                    while (!fast.equals(slow)){
                        fast=fast.next;
                        slow=slow.next;
                    }

                    return fast;
                }
            }

            return null;

        }
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
