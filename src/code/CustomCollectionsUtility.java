package code;

public class CustomCollectionsUtility {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode createListNode(int[] a) {
        if (a.length == 0) {
            return null;
        }
        ListNode toReturn = new ListNode(a[0]);
        ListNode pointer = toReturn;
        for (int i = 1; i < a.length; i++) {
            ListNode s = new ListNode(a[i]);
            pointer.next = s;
            pointer = pointer.next;
        }
        return toReturn;
    }
}
