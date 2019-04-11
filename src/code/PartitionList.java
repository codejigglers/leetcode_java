package code;

public class PartitionList {

    public static void main(String[] args) {

    }

    static class Solution {
        public CustomCollectionsUtility.ListNode partition(CustomCollectionsUtility.ListNode head, int x) {
            CustomCollectionsUtility.ListNode small = new CustomCollectionsUtility.ListNode(1);
            CustomCollectionsUtility.ListNode big = new CustomCollectionsUtility.ListNode(1);

            CustomCollectionsUtility.ListNode toReturn = small;
            CustomCollectionsUtility.ListNode ref = big;

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
