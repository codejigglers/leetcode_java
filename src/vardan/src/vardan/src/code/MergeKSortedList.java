package vardan.src.code;

import vardan.src.code.CustomCollectionsUtility.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static vardan.src.code.CustomCollectionsUtility.createListNode;

public class MergeKSortedList {


    public static void main(String[] args) {
        Solution solution = new Solution();
        CustomCollectionsUtility.ListNode a = createListNode(new int[]{});
        ListNode b = createListNode(new int[]{1});
        ListNode c = createListNode(new int[]{3, 6});

        ListNode[] input = new ListNode[]{a, b};
        solution.mergeKLists(input);
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if(lists.length == 0) {
                return null;
            }

            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val > o2.val) {
                        return 1;
                    } else if (o1.val < o2.val) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            for (ListNode item : lists) {
                pq.add(item);
            }

            ListNode pointer = new ListNode(1);
            ListNode n = pointer;

            while (pq.size() > 0) {
                ListNode m = pq.poll();
                n.next = m;
                n = n.next;
                if(m.next != null) {
                    pq.add(m.next);
                }
            }

            return pointer.next;
        }
    }
}
